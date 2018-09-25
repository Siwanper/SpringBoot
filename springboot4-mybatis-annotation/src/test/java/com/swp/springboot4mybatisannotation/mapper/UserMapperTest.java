package com.swp.springboot4mybatisannotation.mapper;

import com.swp.springboot4mybatisannotation.entity.User;
import com.swp.springboot4mybatisannotation.enums.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 描述:
 * 用户操作测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-25 上午10:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll(){
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

    public  User getOne(){
        User user = userMapper.findUserById((long) 29);
        return user;
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setNickName("lisi");
        user.setPassWord("123");
        user.setUserName("huhu");
        user.setUserSex(UserSexEnum.WOMEN);

        userMapper.insertUser(user);
    }

    @Test
    public void updateUser(){
        User user = getOne();
        user.setUserName("wangwuwu");
        userMapper.updateUser(user);
    }

    @Test
    public void deleteUser() {
        userMapper.deleteUserById((long) 28);
    }

}
