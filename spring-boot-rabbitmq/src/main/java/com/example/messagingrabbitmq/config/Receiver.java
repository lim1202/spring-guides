package com.example.messagingrabbitmq.config;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    
    public void process(String context) {
        System.out.println("Receiver: " + context);
    }

}