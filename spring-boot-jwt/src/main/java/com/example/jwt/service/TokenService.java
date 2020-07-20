package com.example.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwt.entity.User;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String getToken(User user) {
        return JWT.create().withAudience(user.getAccessCode()).sign(Algorithm.HMAC256(user.getAccessKey()));
    }
    
}