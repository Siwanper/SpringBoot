package com.swp.springbootshiro.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * 用户控制器
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-07 2:53 PM
 */

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view") // 权限管理
    public String userInfo(){
        return "userInfo";
    }

    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String userDel(){
        return "userInfoDel";
    }

}
