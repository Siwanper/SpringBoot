package com.swp.springBoot2web.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 描述:
 * Thymeleaf 测试
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-20 上午10:18
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Locale locale, Model model) {
        model.addAttribute("greeting","Hello!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime",formattedDate);
        return "/templates/hello.html";
    }


}
