package com.swp.springboot.service;

import com.github.pagehelper.PageInfo;
import com.swp.springboot.modal.bo.CommentBo;

public interface ICommentService {

    /**
     * 获取文章的评论
     * @param cid
     * @param page
     * @param limit
     * @return
     */
    PageInfo<CommentBo> getComments(Integer cid, int page, int limit);

}
