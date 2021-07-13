package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    void deleteUser(Long id);
    User getUser(Long id);
    void saveUser(User user);
}

