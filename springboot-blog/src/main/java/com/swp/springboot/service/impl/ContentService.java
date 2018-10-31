package com.swp.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swp.springboot.dao.ContentVoMapper;
import com.swp.springboot.dto.Types;
import com.swp.springboot.modal.vo.ContentVo;
import com.swp.springboot.modal.vo.ContentVoExample;
import com.swp.springboot.service.IContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * 文章业务处理
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-31 5:37 PM
 */
@Service
public class ContentService implements IContentService {

    @Resource
    private ContentVoMapper contentVoMapper;

    @Override
    public PageInfo<ContentVo> getArticleList(int page, int limit) {

        ContentVoExample example = new ContentVoExample();
        example.setOrderByClause("created desc");
        ContentVoExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(Types.ARTICLE.getType());
        PageHelper.startPage(page, limit);
        List<ContentVo> contentVos = contentVoMapper.selectByExampleWithBLOBs(example);

        return new PageInfo<>(contentVos);
    }

    @Override
    public ContentVo getContentByCid(Integer cid) {
        if (null != cid) {
            ContentVo contentVo = contentVoMapper.selectByPrimaryKey(cid);
            return contentVo;
        }
        return null;
    }

    @Override
    public void updateCategory(String oldName, String newName) {
        if (StringUtils.isNotBlank(oldName) && StringUtils.isNotBlank(newName)) {
            ContentVoExample example = new ContentVoExample();
            example.createCriteria().andCategoriesEqualTo(oldName);
            ContentVo contentVo = new ContentVo();
            contentVo.setCategories(newName);
            contentVoMapper.updateByExampleSelective(contentVo, example);
        }
    }

    @Override
    public void updateByCid(ContentVo contentVo) {
        if (null != contentVo && null != contentVo.getCid()) {
            contentVoMapper.updateByPrimaryKeySelective(contentVo);
        }
    }
}
