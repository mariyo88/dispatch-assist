package com.firstcode.dispatchassist.repository;

import com.firstcode.dispatchassist.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}