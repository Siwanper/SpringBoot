package com.swp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * docker控制器
 *
 * @outhor ios
 * @create 2018-10-12 3:41 PM
 */
@RestController
public class DockerController {


    @RequestMapping("/")
    public String index(){
        return "Hello Docker!";
    }

}
