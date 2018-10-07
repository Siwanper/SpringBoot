package com.swp.springbootshiro.dao;

import com.swp.springbootshiro.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo, Long> {

    public UserInfo findByUsername(String username);

}
