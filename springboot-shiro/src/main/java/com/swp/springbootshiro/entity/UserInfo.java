package com.swp.springbootshiro.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * 用户信息
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-07 10:11 AM
 */
@Entity
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -4365534407173375709L;
    @Id
    @GeneratedValue
    private Integer uid; // 用户ID
    @Column(unique = true)
    private String username; // 账号
    private String name; // 用户名称
    private String password; // 密码
    private String salt; // 加密密码的盐
    private byte state; // 用户状态，0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户，1：正常状态，2：用户被锁定
    @ManyToMany(fetch = FetchType.EAGER) //立即从数据库中国呢进行加载数据
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = { @JoinColumn(name = "roleId")})
    private List<SysRole> roleList; // 一个用户有多个角色

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 密码盐
     *
     * 重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

}
