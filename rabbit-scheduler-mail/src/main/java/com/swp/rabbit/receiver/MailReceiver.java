package com.swp.rabbit.receiver;

import com.swp.domain.Mail;
import com.swp.mail.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 邮件接收者
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-28 11:06 AM
 */
@Component
@RabbitListener(queues = "mailQueue")
public class MailReceiver {

    @Autowired
    private MailService mailService;

    @RabbitHandler
    public void process(Mail mail){
        mailService.sendMail(mail);
    }

}
