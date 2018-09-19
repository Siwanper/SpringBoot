package com.swp.springBoot2web.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * DESCRIPTION：   ${DESCRIPTION}
 *
 * @ProjectName: springBoot2-web
 * @Package: com.swp.springBoot2web.domain
 * @Author: Siwanper
 * @CreateDate: 2018/9/19 下午10:22
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */

//Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String nickName;
    @Column(nullable = false)
    private String regTime;
//    @Transient
//    private Integer age;

// 默认构造器必须初始化
    public User() {
    }

    public User(String userName, String passWord, String email, String nickName, String regTime) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

}
