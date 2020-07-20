package com.example.messagingrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public final static String EXCHANGE = "spring-boot-exchange";
    public final static String QUEUE = "spring-boot";
    public final static String ROUTE = "foo.bar.baz";
    
    @Bean
    public Queue queue() {
        return new Queue(QUEUE, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
        MessageListenerAdapter listenerAdapter) {
      SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
      container.setConnectionFactory(connectionFactory);
      container.setQueueNames(QUEUE);
      container.setMessageListener(listenerAdapter);
      return container;
    }
  
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
      return new MessageListenerAdapter(receiver, "process");
    }

}