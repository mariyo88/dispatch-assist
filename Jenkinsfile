#!groovy
// @Library('halcom-jenkins-shared-lib') _

properties properties: [
	[$class: 'ParametersDefinitionProperty', parameterDefinitions: [
		[$class: 'BooleanParameterDefinition', name: 'sonar', defaultValue: false, description: 'Do sonar analysis?'],
		[$class: 'BooleanParameterDefinition', name: 'docker', defaultValue: false, description: 'Build docker images?']
	]]
]

node ('jenkins') {
	try {
		env.JAVA_HOME = tool 'AdoptOpenJDK11'
		env.MAVEN_OPTS='-Xss2048k'
		defmvnHome=tool'M3'
		def repoName= determineRepoName()

		stage ('Checkout') {
			checkout scm
			pom = readMavenPom file: 'pom.xml'
		}

		stage ('Clean') {
			sh "${mvnHome}/bin/mvn -f pom.xml clean -T 4 -B -U -DskipTests=true"
		}

		stage ('Build') {
			sh "${mvnHome}/bin/mvn -f pom.xml package -T 4 -B -U -DskipTests=true"
		}

		stage ('Test') {
			sh "${mvnHome}/bin/mvn -f pom.xml verify -T 4 -B -P sonarqube"
			junit allowEmptyResults: true, testResults: '**/target/*-reports/TEST-*.xml'
		}
		
		stage ('Sonarqube') {
			if (env.sonar != null && env.sonar.toBoolean()) {
				sonarqubeAnalysis("java", projectName:"${repoName}", projectKey:"${repoName}", mvnHome:"${mvnHome}")
			}
		}

// 		stage ('Deploy') {
// 			sh "${mvnHome}/bin/mvn -f pom.xml deploy -B -P nexus-halcom -DskipTests=true -Dmaven.install.skip=true"
// 		}
		
// 		stage ('Docker') {
// 			if (env.docker != null && env.docker.toBoolean()) {
// 				sh "${mvnHome}/bin/mvn -f pom.xml package -B -P docker -DskipTests=true -Dmaven.source.skip=true -Dmaven.install.skip=true"
// 				pushDockerImage("${repoName}:${pom.properties['revision']}")
// 				pushDockerImage("${repoName}.dev:${pom.properties['revision']}")
// 			}
// 		}
		
	} catch (e) {
		currentBuild.result = "FAILED"
		throw e
	} finally {
		notifyBuild(currentBuild.result)
	}
}