package com.swp.springBoot3jpathymleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:
 * hello world
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-21 下午2:08
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model,@RequestParam(defaultValue = "World", required = false, value = "name") String name) {
        model.addAttribute("name",name);
        return "hello";
    }

}
