package com.swp.springBoot3jpathymleaf.service.impl;

import com.swp.springBoot3jpathymleaf.entity.User;
import com.swp.springBoot3jpathymleaf.repository.UserRepository;
import com.swp.springBoot3jpathymleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * 用户Service实现
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-21 下午2:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void save(User user) {
        // 如果没有主键则保存
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        // 如果有主键则修改
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
