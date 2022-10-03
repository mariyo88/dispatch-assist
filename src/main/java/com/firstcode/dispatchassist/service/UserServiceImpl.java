package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.Authorities;
import com.firstcode.dispatchassist.model.User;
import com.firstcode.dispatchassist.repository.AuthoritiesRepository;
import com.firstcode.dispatchassist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final AuthoritiesRepository authoritiesRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Authorities authorities = Authorities.builder().username(user.getUsername()).authority("ROLE_USER").build();
        User theUser = repository.save(user);
        authoritiesRepository.save(authorities);
        return theUser;
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException();
        }

        return optionalUser.get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public void saveImage(User user) {
        repository.save(user);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
