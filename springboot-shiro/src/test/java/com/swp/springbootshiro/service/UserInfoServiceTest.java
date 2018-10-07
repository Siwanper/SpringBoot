package com.swp.springbootshiro.service;

import com.swp.springbootshiro.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * 用户数据测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-07 11:17 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void userServiceTest(){

        UserInfo userInfo = userInfoService.findByUsername("admin");
        System.out.println(userInfo);

    }

}
