package com.swp.springboot.controller.admin;

import com.swp.springboot.controller.AbstractController;
import com.swp.springboot.exception.TipException;
import com.swp.springboot.modal.bo.RestResponseBo;
import com.swp.springboot.modal.vo.CommentVo;
import com.swp.springboot.service.ISiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * 首页
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-25 4:34 PM
 */
@Controller("adminIndexController")
@RequestMapping("/admin")
@Transactional(rollbackFor = TipException.class)
public class IndexController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private ISiteService siteService;

    @GetMapping(value = {"", "/index"})
    @ResponseBody
    public RestResponseBo index(){

        List<CommentVo> commentVos = siteService.recentComments(5);

        return RestResponseBo.ok();
    }

}
