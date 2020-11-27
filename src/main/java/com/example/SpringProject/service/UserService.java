package com.example.SpringProject.service;

import com.example.SpringProject.model.User;

public interface UserService {
    User save(User user);

    User findByName(String name);
}
