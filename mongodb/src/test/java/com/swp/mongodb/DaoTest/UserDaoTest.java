package com.swp.mongodb.DaoTest;

import com.swp.mongodb.dao.UserDao;
import com.swp.mongodb.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2018-09-27 5:41 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void addUser(){
        UserEntity user = new UserEntity();
        user.setId(3l);
        user.setUserName("zhangsan");
        user.setPassWord("123456");
        userDao.saveUser(user);
    }

    @Test
    public void findAll(){
        List<UserEntity> users = userDao.findAll();
        System.out.println(users);
    }

    @Test
    public void findOne(){
        UserEntity user = userDao.findUserByUsername("shiwanpeng");
        System.out.println(user);
    }

    @Test
    public void update(){
        UserEntity user = new UserEntity();
        user.setId(3l);
        user.setUserName("lisi");
        user.setPassWord("23456");
        userDao.updateUser(user);
    }

    @Test
    public  void delete(){
        userDao.deleteUser(3l);
    }
}
