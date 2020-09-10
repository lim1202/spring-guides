package com.example.spring.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class StreamReceiver {
    
    private static final Logger logger = LoggerFactory.getLogger(StreamReceiverApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(String message) {
        logger.info("Message: {}", message);
    }
}
