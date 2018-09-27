package com.swp.mongodb.dao;

import com.swp.mongodb.entity.UserEntity;

import java.util.List;

public interface UserDao {

    public void saveUser(UserEntity user);
    public List<UserEntity> findAll();
    public UserEntity findUserByUsername(String userName);
    public void updateUser(UserEntity user);
    public void deleteUser(Long id);

}
