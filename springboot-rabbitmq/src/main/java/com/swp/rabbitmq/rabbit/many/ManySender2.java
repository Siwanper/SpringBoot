package com.swp.rabbitmq.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 描述:
 * 多对多使用
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:25
 */
@Component
public class ManySender2 {

    @Autowired
    private AmqpTemplate template;

    public void send(int i){
        String context = "many2 :" + new Date() + "**********" + i;
        System.out.println("ManySender2 : " + context);
        template.convertAndSend("many",context);
    }

}
