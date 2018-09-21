package com.swp.springBoot3jpathymleaf.service;

import com.swp.springBoot3jpathymleaf.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findUserById(Long id);
    public void save(User user);
    public void edit(User user);
    public void deleteUserById(Long id);
}
