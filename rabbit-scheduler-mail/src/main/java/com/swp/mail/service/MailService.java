package com.swp.mail.service;

import com.swp.domain.Mail;

public interface MailService {

    /**
     * 发送邮件
     *
     * @param mail
     */
    public void sendMail(Mail mail);

}
