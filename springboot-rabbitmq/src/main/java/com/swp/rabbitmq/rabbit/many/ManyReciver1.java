package com.swp.rabbitmq.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 多对多接受者
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:27
 */
@Component
@RabbitListener(queues = "many")
public class ManyReciver1 {

    @RabbitHandler
    public void process(String context) {
        System.out.println("ManyReciver1 : "+ context);
    }

}
