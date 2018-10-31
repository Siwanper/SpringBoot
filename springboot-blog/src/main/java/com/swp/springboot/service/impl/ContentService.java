package com.swp.springboot.service.impl;

import com.swp.springboot.dao.ContentVoMapper;
import com.swp.springboot.modal.vo.ContentVo;
import com.swp.springboot.modal.vo.ContentVoExample;
import com.swp.springboot.service.IContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public void updateCategory(String oldName, String newName) {
        if (StringUtils.isNotBlank(oldName) && StringUtils.isNotBlank(newName)) {
            ContentVoExample example = new ContentVoExample();
            example.createCriteria().andCategoriesEqualTo(oldName);
            ContentVo contentVo = new ContentVo();
            contentVo.setCategories(newName);
            contentVoMapper.updateByExampleSelective(contentVo, example);
        }
    }
}
