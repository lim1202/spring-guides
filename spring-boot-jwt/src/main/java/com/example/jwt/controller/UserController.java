package com.example.jwt.controller;

import javax.validation.Valid;

import com.example.jwt.config.PassAuth;
import com.example.jwt.entity.User;
import com.example.jwt.service.TokenService;
import com.example.jwt.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PassAuth
    @PostMapping("/login")
    public String login(@RequestBody @Valid User user) {
        User userForAuth = userService.findByCode(user.getAccessCode());
        if(userForAuth == null){
            return "Login failed! User not exist!";
        }else {
            if (!userForAuth.getAccessKey().equals(user.getAccessKey())){
                return "Login failed! Wrong Access Key!";
            }else {
                String token = tokenService.getToken(user);
                return token;
            }
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}