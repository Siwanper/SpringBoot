package com.swp.springbootshiro.service;

import com.swp.springbootshiro.entity.UserInfo;

public interface UserInfoService {

    public UserInfo findByUsername(String username);
}
