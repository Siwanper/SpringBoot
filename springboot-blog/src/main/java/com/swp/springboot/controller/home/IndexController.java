package com.swp.springboot.controller.home;

import com.swp.springboot.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:
 * 首页控制
 *
 * @outhor ios
 * @create 2018-10-27 3:17 PM
 */
@Controller
public class IndexController extends AbstractController{

    private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "博客首页";
    }

}
