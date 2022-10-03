package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User register(User user);

    User findById(Long id);

    void deleteById(Long id);

    User findByUserName(String userName);

    void saveImage(User user);

    void save(User user);
}
