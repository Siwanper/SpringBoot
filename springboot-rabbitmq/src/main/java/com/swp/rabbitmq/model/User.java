package com.swp.rabbitmq.model;

import java.io.Serializable;

/**
 * 描述:
 * yonghu
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午2:58
 */
public class User implements Serializable{

    private String name;

    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

}
