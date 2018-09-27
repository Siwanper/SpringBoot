package com.swp.mongodb.dao.impl;

import com.swp.mongodb.dao.UserDao;
import com.swp.mongodb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述:
 * 用户Dao实现
 *
 * @outhor ios
 * @create 2018-09-27 5:32 PM
 */
@Component
public class UserDaoImpl  implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> userList = mongoTemplate.findAll(UserEntity.class);
        return userList;
    }

    @Override
    public UserEntity findUserByUsername(String userName) {

        Query query = new Query(Criteria.where("userName").is(userName));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        return user;
    }

    @Override
    public void updateUser(UserEntity user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName",user.getUserName()).set("passWord",user.getPassWord());
        mongoTemplate.updateFirst(query,update,UserEntity.class);
    }

    @Override
    public void deleteUser(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
