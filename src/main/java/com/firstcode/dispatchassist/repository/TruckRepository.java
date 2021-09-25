package com.firstcode.dispatchassist.repository;

import com.firstcode.dispatchassist.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}