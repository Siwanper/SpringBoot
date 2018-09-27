package com.swp.schedule_mail.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * 发送邮箱测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-27 11:43 AM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleMailTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail(){
        mailService.sendSimpleMail("272287829@qq.com","test simple mail","hello this a simle mail");
    }

}
