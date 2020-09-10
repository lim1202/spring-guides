package com.example.spring.cloud;

import java.time.Instant;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class StreamProcessor {
    
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String process(String message) {
        return String.format("%s, Timestamp: %s", message, Instant.now().toString());
    }
}
