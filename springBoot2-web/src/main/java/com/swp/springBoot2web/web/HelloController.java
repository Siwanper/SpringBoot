package com.swp.springBoot2web.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * hello
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-19 下午5:26
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello world";
    }

}
