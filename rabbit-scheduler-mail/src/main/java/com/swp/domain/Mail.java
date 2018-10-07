package com.swp.domain;

/**
 * 描述:
 * 邮件
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-28 11:36 AM
 */
public class Mail {

    private String to;
    private String subject;
    private String context;

    public Mail() {
    }

    public Mail(String to, String subject, String context) {
        this.to = to;
        this.subject = subject;
        this.context = context;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
