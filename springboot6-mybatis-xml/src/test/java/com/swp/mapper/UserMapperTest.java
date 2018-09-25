package com.swp.mapper;

import com.swp.entity.User;
import com.swp.enums.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 描述:
 * 用户测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-25 下午2:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll(){
        List<User> userList = userMapper.getAll();
        System.out.println(userList);
    }

    @Test
    public void getOne(){
        User user = userMapper.getOne((long) 29);
        System.out.println(user);
    }

    @Test
    public void insert(){
        User user = new User();
        user.setUserName("liliuliu");
        user.setPassWord("13132");
        user.setNickName("dede");
        user.setUserSex(UserSexEnum.MAN);
        userMapper.insert(user);
    }

    @Test
    public void delete(){
        userMapper.delete((long) 29);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId((long) 30);
        user.setUserName("liliuliu255");
        user.setPassWord("65656");
        user.setNickName("dede");
        user.setUserSex(UserSexEnum.WOMAN);
        userMapper.update(user);
    }
}
