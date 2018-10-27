package com.swp.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.swp.springboot.dao.AttachVoMapper;
import com.swp.springboot.dao.CommentVoMapper;
import com.swp.springboot.dao.ContentVoMapper;
import com.swp.springboot.dao.MetaVoMapper;
import com.swp.springboot.dto.Types;
import com.swp.springboot.modal.bo.StaticticsBo;
import com.swp.springboot.modal.vo.*;
import com.swp.springboot.service.ISiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * 网站业务处理
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-27 4:55 PM
 */
@Service
public class SiteServiceImpl implements ISiteService {

    @Resource
    private CommentVoMapper commentVoDao;

    @Resource
    private ContentVoMapper contentVoDao;

    @Resource
    private AttachVoMapper attachVoDao;

    @Resource
    private MetaVoMapper metaVoDao;

    @Override
    public List<CommentVo> recentComments(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        CommentVoExample commentVoExample = new CommentVoExample();
        commentVoExample.setOrderByClause("created desc");
        PageHelper.startPage(1,limit);
        List<CommentVo> commentVoList = commentVoDao.selectByExampleWithBLOBs(commentVoExample);
        return commentVoList;
    }

    @Override
    public List<ContentVo> recentContents(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        ContentVoExample example = new ContentVoExample();
        example.createCriteria().andStatusEqualTo(Types.PUBLISH.getType())
                .andTypeEqualTo(Types.ARTICLE.getType());
        PageHelper.startPage(1,limit);
        List<ContentVo> contentVos = contentVoDao.selectByExampleWithBLOBs(example);
        return contentVos;
    }

    @Override
    public CommentVo getCommont(Integer coid) {
        if (null != coid) {
            commentVoDao.selectByPrimaryKey(coid);
        }
        return null;
    }

    @Override
    public StaticticsBo getStatictics() {
        StaticticsBo staticticsBo = new StaticticsBo();

        ContentVoExample example = new ContentVoExample();
        example.createCriteria().andStatusEqualTo(Types.PUBLISH.getType())
                .andTypeEqualTo(Types.ARTICLE.getType());
        Long articles = contentVoDao.countByExample(example);
        Long comments = commentVoDao.countByExample(new CommentVoExample());
        Long attachs = attachVoDao.countByExample(new AttachVoExample());

        MetaVoExample metaVoExample = new MetaVoExample();
        metaVoExample.createCriteria().andTypeEqualTo(Types.LINK.getType());
        Long links = metaVoDao.countByExample(metaVoExample);

        staticticsBo.setArticles(articles);
        staticticsBo.setComments(comments);
        staticticsBo.setAttachs(attachs);
        staticticsBo.setLinks(links);
        return staticticsBo;
    }
}
