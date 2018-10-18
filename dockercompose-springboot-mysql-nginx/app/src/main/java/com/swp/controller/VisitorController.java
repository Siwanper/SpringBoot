package com.swp.controller;

import com.swp.entity.Visitor;
import com.swp.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 * 访问者控制器
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-18 11:16 AM
 */
@RestController
public class VisitorController {

    @Autowired
    private VisitorRepository repository;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {

        String ip = request.getRemoteAddr();
        Visitor visitor = repository.findByIp(ip);
        System.out.println("ip : == " + ip);
        if (visitor == null) {
            visitor = new Visitor();
            visitor.setIp(ip);
            visitor.setTimes(1l);
        }else {
            visitor.setTimes(visitor.getTimes() + 1);
        }
        repository.save(visitor);
        return "I hava been seen ip " + visitor.getIp() + " " + visitor.getTimes() + " times";
    }


}
