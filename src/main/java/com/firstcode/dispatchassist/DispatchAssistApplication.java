package com.firstcode.dispatchassist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DispatchAssistApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DispatchAssistApplication.class);
        application.setAdditionalProfiles("ssl");
        application.run(args);
    }

}
