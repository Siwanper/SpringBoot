package com.swp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 描述:
 * 访问者
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-18 11:09 AM
 */
@Entity
public class Visitor {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String ip;
    @Column(nullable = false)
    private Long times;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }
}
