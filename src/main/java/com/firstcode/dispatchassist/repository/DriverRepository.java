package com.firstcode.dispatchassist.repository;

import com.firstcode.dispatchassist.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}