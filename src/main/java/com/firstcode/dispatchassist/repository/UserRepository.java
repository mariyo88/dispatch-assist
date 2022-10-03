package com.firstcode.dispatchassist.repository;

import com.firstcode.dispatchassist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}