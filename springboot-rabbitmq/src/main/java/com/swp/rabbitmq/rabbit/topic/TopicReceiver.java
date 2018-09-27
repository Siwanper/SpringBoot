package com.swp.rabbitmq.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 接受者
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午4:18
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

    @RabbitHandler
    public void process( String message ){
        System.out.println("Topic Receiver1  : " + message);
    }

}
