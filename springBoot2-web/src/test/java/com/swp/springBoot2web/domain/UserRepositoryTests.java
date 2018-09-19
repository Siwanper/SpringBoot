package com.swp.springBoot2web.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * DESCRIPTION：   ${DESCRIPTION}
 *
 * @ProjectName: springBoot2-web
 * @Package: com.swp.springBoot2web.domain
 * @Author: Siwanper
 * @CreateDate: 2018/9/19 下午10:46
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        Date date = new Date();
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("dd","dd123456","dd@123.com","dd1",formattedDate));
//        userRepository.save(new User("bb","bb123456","bb@123.com","bb1",formattedDate));
//        userRepository.save(new User("cc","cc123456","cc@123.com","cc1",formattedDate));

        userRepository.delete(userRepository.findByUserName("aa"));

    }


}
