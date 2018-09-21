package com.swp.springBoot3jpathymleaf.user;

import com.swp.springBoot3jpathymleaf.entity.User;
import com.swp.springBoot3jpathymleaf.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * 用户数据测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-21 下午4:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testPageQuery(){
        int page = 1, size = 10;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<User> users = userRepository.findAll(pageable);
        System.out.println("users : "+users);
    }

}
