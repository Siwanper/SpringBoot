package com.swp.springBoot2web.web;

import com.swp.springBoot2web.util.MyProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * 属性测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-19 下午5:40
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private MyProperties myProperties;

    @Test
    public void getProperties(){
        System.out.println(myProperties.getTitle());
        System.out.println(myProperties.getDescription());
    }
}
