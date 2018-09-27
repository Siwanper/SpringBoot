package com.swp.rabbitmq.rabbit.object;

import com.swp.rabbitmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 对象
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:44
 */
@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate template;

    public void sender(User user){
        System.out.println("ObjectSender : "+ user.toString());
        template.convertAndSend("object",user);
    }

}
