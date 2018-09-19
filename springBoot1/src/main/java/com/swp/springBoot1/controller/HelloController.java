package com.swp.springBoot1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * Spring Boot init
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-19 下午12:29
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

}
