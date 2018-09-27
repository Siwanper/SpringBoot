package com.swp.rabbitmq.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * Topic
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午4:11
 */

@Configuration
public class TopicRabbitConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage(){
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(TopicRabbitConfig.messages);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("TopicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
