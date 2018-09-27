package com.swp.rabbitmq.rabbit.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 描述:
 * 发送者
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:01
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello" + new Date();
        System.out.println("Sender : "+context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }

}
