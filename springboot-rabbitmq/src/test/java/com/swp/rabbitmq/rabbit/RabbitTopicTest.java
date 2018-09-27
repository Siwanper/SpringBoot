package com.swp.rabbitmq.rabbit;

import com.swp.rabbitmq.model.User;
import com.swp.rabbitmq.rabbit.object.ObjectSender;
import com.swp.rabbitmq.rabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * 对象测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午3:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTopicTest {

    @Autowired
    private TopicSender sender;

    @Test
    public void topic() throws Exception {
        sender.send();
    }

    @Test
    public void topic1() throws Exception {
        sender.send1();
    }

    @Test
    public void topic2() throws Exception {
        sender.send2();
    }

}
