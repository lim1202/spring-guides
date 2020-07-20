package com.example.messagingrabbitmq;

import java.time.LocalDateTime;

import com.example.messagingrabbitmq.config.RabbitConfig;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        String context = "Message: <" + message + "> @" + LocalDateTime.now().toString();
        System.out.println("Sender: " + context);
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTE, context);
    }

}