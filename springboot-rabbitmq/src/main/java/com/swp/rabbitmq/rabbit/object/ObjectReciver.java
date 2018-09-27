package com.swp.rabbitmq.rabbit.object;

import com.swp.rabbitmq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 对象接受者
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:46
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReciver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("ObjectReciver : "+user.toString());
    }

}
