package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    StringRedisTemplate redisTemplate;

    public String get(String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return  ops.get(key);
    }

    public void set(String key, String value) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value);
    }
    
    public void delete(String key) {
        redisTemplate.delete(key);
    } 
}