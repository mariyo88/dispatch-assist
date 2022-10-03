package com.firstcode.dispatchassist.repository;

import com.firstcode.dispatchassist.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
}