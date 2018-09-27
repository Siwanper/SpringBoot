package com.swp.rabbitmq.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 接受者
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:03
 */

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String context) {
        System.out.println("Receiver : "+context);
    }

}
