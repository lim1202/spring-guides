package com.example.spring.cloud;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@EnableBinding(Source.class)
public class StreamSender {
    
    @Autowired
    private Source source;

    @Scheduled(fixedDelay = 1000)
    public void send() {
        String payload = UUID.randomUUID().toString();
        this.source.output().send(MessageBuilder.withPayload(payload).build());
    }
}
