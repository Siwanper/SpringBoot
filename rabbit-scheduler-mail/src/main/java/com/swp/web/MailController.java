package com.swp.web;

import com.swp.domain.Mail;
import com.swp.rabbit.sender.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 发送邮件
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-28 12:07 PM
 */

@RestController
public class MailController {

    private MailSender sender = new MailSender();

    @RequestMapping("/mail")
    public void mail(){
        Mail mail  = new Mail();
        mail.setTo("272287829@qq.com");
        mail.setSubject("国庆节快乐");
        mail.setContext("祝各位国庆节快乐！！！");
        sender.send(mail);
    }

}
