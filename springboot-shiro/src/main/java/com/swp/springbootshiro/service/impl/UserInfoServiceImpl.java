package com.swp.springbootshiro.service.impl;

import com.swp.springbootshiro.dao.UserInfoDao;
import com.swp.springbootshiro.entity.UserInfo;
import com.swp.springbootshiro.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 * 用户信息服务
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-07 11:15 AM
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
