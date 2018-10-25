package com.swp.springboot.controller.admin;

import com.swp.springboot.controller.AbstractController;
import com.swp.springboot.exception.TipException;
import com.swp.springboot.modal.bo.RestResponseBo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:
 * 首页
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-25 4:34 PM
 */
@Controller
@RequestMapping("/admin")
@Transactional(rollbackFor = TipException.class)
public class IndexController extends AbstractController {

    @GetMapping(value = {"", "/index"})
    @ResponseBody
    public RestResponseBo index(){
        return RestResponseBo.ok();
    }

}
