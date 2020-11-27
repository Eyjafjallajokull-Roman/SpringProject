package com.example.SpringProject.service.serviceImpl;

import com.example.SpringProject.model.Role;
import com.example.SpringProject.model.User;
import com.example.SpringProject.repository.UserRepository;
import com.example.SpringProject.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public User save(User user) {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         repository.save(user);

        log.info("Stored user {}", user.getName());
        return repository.save(user);
    }

    @Override
    public User findByName(String name) {
        log.info("find user by this name " + name);
        return repository.findByName(name);
    }
}
