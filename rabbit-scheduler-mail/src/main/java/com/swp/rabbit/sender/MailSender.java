package com.swp.rabbit.sender;

import com.swp.domain.Mail;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 邮件发送者
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-28 11:03 AM
 */
@Component
public class MailSender {

    @Autowired
    private RabbitTemplate template;

    public void send(Mail mail) {
        System.out.println(mail.getSubject());
        template.convertAndSend("mailQueue",mail);
    }

}
