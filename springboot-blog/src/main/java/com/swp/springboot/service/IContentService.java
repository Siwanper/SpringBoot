package com.swp.springboot.service;

import com.github.pagehelper.PageInfo;
import com.swp.springboot.modal.vo.ContentVo;

public interface IContentService {

    /**
     * 获取文章列表
     *
     * @param page
     * @param limit
     * @return
     */
    PageInfo<ContentVo> getArticleList(int page, int limit);

    /**
     * 获取文章
     *
     * @param cid
     * @return
     */
    ContentVo getContentByCid(Integer cid);

    /**
     * 更新文章的类别和标签
     *
     * @param oldName
     * @param newName
     */
    void updateCategory(String oldName, String newName);

    /**
     * 更新文章
     *
     * @param contentVo
     */
    void updateByCid(ContentVo contentVo);

    /**
     * 发表文章
     * @param contentVo
     */
    void publish(ContentVo contentVo);
}
