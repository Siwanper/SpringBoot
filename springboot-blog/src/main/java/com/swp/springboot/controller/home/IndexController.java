package com.swp.springboot.controller.home;

import com.github.pagehelper.PageInfo;
import com.swp.springboot.constant.WebConst;
import com.swp.springboot.controller.AbstractController;
import com.swp.springboot.exception.TipException;
import com.swp.springboot.modal.bo.CommentBo;
import com.swp.springboot.modal.vo.ContentVo;
import com.swp.springboot.service.ICommentService;
import com.swp.springboot.service.IContentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @Resource
    private IContentService contentService;

    @Resource
    private ICommentService commentService;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "博客首页";
    }

    @GetMapping(value = {"article/{cid}/preview", "article/{cid}.html"})
    public String articlePreview(HttpServletRequest request, @PathVariable Integer cid) {
        ContentVo content = contentService.getContentByCid(cid);
        if (null == content) {
            return this.render_404();
        }
        request.setAttribute("article", content);
        request.setAttribute("is_post", true);
        compeleArticle(request, content);
        updateArticleHit(content.getCid(), content.getHits());
        return this.render("post");
    }

    /**
     * 更新点击次数
     *
     * @param cid
     * @param chits
     */
    @Transactional(rollbackFor = TipException.class)
    protected void updateArticleHit(Integer cid, Integer chits) {
        Integer hits = cache.hget("article", "hits");
        if (chits == null) {
            chits = 0;
        }
        hits = null == hits ? 1 : hits + 1;
        if (hits >= WebConst.HIT_EXCEED) {
            ContentVo temp = new ContentVo();
            temp.setCid(cid);
            temp.setHits(chits + hits);
            contentService.updateByCid(temp);
            cache.hset("article", "hits", 1);
        } else {
            cache.hset("article", "hits", 1);
        }
    }

    private void compeleArticle(HttpServletRequest request, ContentVo content) {
        if (content.getAllowComment()) {
            String cp = request.getParameter("cp");
            if (StringUtils.isBlank(cp)) {
                cp = "1";
            }
            request.setAttribute("cp", cp);
            PageInfo<CommentBo> commentsPaginator = commentService.getComments(content.getCid(), Integer.parseInt(cp), 6);
            request.setAttribute("comments", commentsPaginator);
        }
    }

}
