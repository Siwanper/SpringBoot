package com.swp.springBoot3jpathymleaf.web;

import com.swp.springBoot3jpathymleaf.entity.User;
import com.swp.springBoot3jpathymleaf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * 用户控制器
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-21 下午2:47
 */

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> userlist = userService.findAll();
        model.addAttribute("userList",userlist);
        return "user/list";
    }

    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/edit")
    public String edit(Long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/edit";
    }

    @RequestMapping("/delete")
    public String delete(Long id){
        userService.deleteUserById(id);
        return "redirect:/list";
    }


}
