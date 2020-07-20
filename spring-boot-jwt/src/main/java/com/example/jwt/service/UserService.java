package com.example.jwt.service;

import com.example.jwt.entity.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    public User findByCode(String code) {
        User user = new User();
        user.setId(0);
        user.setName("name");
        user.setAccessCode(code);
        user.setAccessKey("key");
        return user;
    }
}