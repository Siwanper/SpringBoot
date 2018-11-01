package com.swp.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swp.springboot.dao.CommentVoMapper;
import com.swp.springboot.modal.bo.CommentBo;
import com.swp.springboot.modal.vo.CommentVo;
import com.swp.springboot.modal.vo.CommentVoExample;
import com.swp.springboot.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 文章评论的业务处理
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-11-01 5:00 PM
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentVoMapper commentDao;

    @Override
    public PageInfo<CommentBo> getComments(Integer cid, int page, int limit) {
        if (null != cid) {
            PageHelper.startPage(page, limit);
            CommentVoExample commentVoExample = new CommentVoExample();
            commentVoExample.createCriteria().andCidEqualTo(cid).andParentEqualTo(0);
            commentVoExample.setOrderByClause("coid desc");
            List<CommentVo> parents = commentDao.selectByExampleWithBLOBs(commentVoExample);
            PageInfo<CommentVo> commentPaginator = new PageInfo<>(parents);
            PageInfo<CommentBo> returnBo = copyPageInfo(commentPaginator);
            if (parents.size() != 0) {
                List<CommentBo> comments = new ArrayList<>(parents.size());
                parents.forEach(parent -> {
                    CommentBo comment = new CommentBo(parent);
                    comments.add(comment);
                });
                returnBo.setList(comments);
            }
            return returnBo;
        }
        return null;
    }

    /**
     * copy原有的分页信息，除数据
     *
     * @param ordinal
     * @param <T>
     * @return
     */
    private <T> PageInfo<T> copyPageInfo(PageInfo ordinal) {
        PageInfo<T> returnBo = new PageInfo<T>();
        returnBo.setPageSize(ordinal.getPageSize());
        returnBo.setPageNum(ordinal.getPageNum());
        returnBo.setEndRow(ordinal.getEndRow());
        returnBo.setTotal(ordinal.getTotal());
        returnBo.setHasNextPage(ordinal.isHasNextPage());
        returnBo.setHasPreviousPage(ordinal.isHasPreviousPage());
        returnBo.setIsFirstPage(ordinal.isIsFirstPage());
        returnBo.setIsLastPage(ordinal.isIsLastPage());
        returnBo.setNavigateFirstPage(ordinal.getNavigateFirstPage());
        returnBo.setNavigateLastPage(ordinal.getNavigateLastPage());
        returnBo.setNavigatepageNums(ordinal.getNavigatepageNums());
        returnBo.setSize(ordinal.getSize());
        returnBo.setPrePage(ordinal.getPrePage());
        returnBo.setNextPage(ordinal.getNextPage());
        return returnBo;
    }
}
