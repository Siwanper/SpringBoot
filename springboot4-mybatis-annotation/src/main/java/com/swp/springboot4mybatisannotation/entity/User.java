package com.swp.springboot4mybatisannotation.entity;

import com.swp.springboot4mybatisannotation.enums.UserSexEnum;

import java.io.Serializable;

/**
 * 描述:
 * 用户
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-25 上午10:45
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1405394801828944612L;

    private Long id;
    private String userName;
    private String passWord;
    private String nickName;
    private UserSexEnum userSex;

    public User() {
    }

    public User(Long id, String userName, String passWord, String nickName, UserSexEnum userSex) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
        this.userSex = userSex;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userSex=" + userSex +
                '}';
    }
}
