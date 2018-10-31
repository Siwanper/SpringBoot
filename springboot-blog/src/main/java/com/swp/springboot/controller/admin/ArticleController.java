package com.swp.springboot.controller.admin;

import com.github.pagehelper.PageInfo;
import com.swp.springboot.controller.AbstractController;
import com.swp.springboot.modal.vo.ContentVo;
import com.swp.springboot.modal.vo.ContentVoExample;
import com.swp.springboot.service.IContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * DESCRIPTION：   ${DESCRIPTION}
 *
 * @ProjectName: springboot-blog
 * @Package: com.swp.springboot.controller.admin
 * @Author: Siwanper
 * @CreateDate: 2018/10/31 下午10:56
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends AbstractController {

    @Resource
    private IContentService contentService;

    @GetMapping("")
    public String index(@RequestParam(value = "page" , defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit,
                        HttpServletRequest request){
        PageInfo<ContentVo> articleList = contentService.getArticleList(page, limit);
        request.setAttribute("articles", articleList);
        return "admin/article_list";
    }

}
