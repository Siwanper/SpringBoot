package com.swp.rabbitmq.rabbit;

import com.swp.rabbitmq.rabbit.many.ManySender1;
import com.swp.rabbitmq.rabbit.many.ManySender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * 多对多使用
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitManyTest {

    @Autowired
    private ManySender1 sender1;

    @Autowired
    private ManySender2 sender2;

    @Test
    public void oneToMany(){
        for (int i = 0; i < 100 ; i++) {
            sender1.send(i);
        }
    }

    @Test
    public void manyToMany(){
        for (int i = 0; i < 100 ; i++) {
            sender1.send(i);
            sender2.send(i);
        }
    }

}
