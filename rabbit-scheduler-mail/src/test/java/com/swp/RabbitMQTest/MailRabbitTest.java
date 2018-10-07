package com.swp.RabbitMQTest;

import com.swp.domain.Mail;
import com.swp.rabbit.sender.MailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * 发送邮件Rabbit测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-28 11:10 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailRabbitTest {

    private MailSender sender = new MailSender();

    @Test
    public void sendMail(){
        Mail mail  = new Mail();
        mail.setTo("272287829@qq.com");
        mail.setSubject("国庆节快乐");
        mail.setContext("祝各位国庆节快乐！！！");
        sender.send(mail);
    }

}
