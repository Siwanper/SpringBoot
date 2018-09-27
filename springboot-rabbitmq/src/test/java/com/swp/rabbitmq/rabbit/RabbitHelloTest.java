package com.swp.rabbitmq.rabbit;

import com.swp.rabbitmq.rabbit.hello.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * rabbit 基础测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitHelloTest {

    @Autowired
    private HelloSender sender;

    @Test
    public void hello(){
        sender.send();
    }

}
