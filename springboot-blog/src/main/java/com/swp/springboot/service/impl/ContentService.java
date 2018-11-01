package com.swp.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swp.springboot.dao.ContentVoMapper;
import com.swp.springboot.dto.Types;
import com.swp.springboot.exception.TipException;
import com.swp.springboot.modal.vo.ContentVo;
import com.swp.springboot.modal.vo.ContentVoExample;
import com.swp.springboot.service.IContentService;
import com.swp.springboot.service.IMetaService;
import com.swp.springboot.util.DateKit;
import com.swp.springboot.util.MyUtils;
import com.vdurmont.emoji.EmojiParser;
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

    @Resource
    private IMetaService metaService;

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

    @Override
    public void publish(ContentVo contents) {
        checkContent(contents);
        if (StringUtils.isNotBlank(contents.getSlug())) {
            if (contents.getSlug().length() < 5) {
                throw new TipException("路径太短了");
            }
            if (!MyUtils.isSlugPath(contents.getSlug())) {
                throw new TipException("您输入的路径不合法");
            }
            ContentVoExample contentVoExample = new ContentVoExample();
            contentVoExample.createCriteria().andTypeEqualTo(contents.getType()).andSlugEqualTo(contents.getSlug());
            long count = contentVoMapper.countByExample(contentVoExample);
            if (count > 0) {
                throw new TipException("该路径已经存在，请重新输入");
            }
        } else {
            contents.setSlug(null);
        }
        // 去除表情
        contents.setContent(EmojiParser.parseToAliases(contents.getContent()));

        int time = DateKit.getCurrentUnixTime();
        contents.setCreated(time);
        contents.setModified(time);
        contents.setHits(0);
        contents.setCommentsNum(0);

        contentVoMapper.insert(contents);

        String tags = contents.getTags();
        String categories = contents.getCategories();
        Integer cid = contents.getCid();
        System.out.println("cid ===== " + cid);
        metaService.saveMetas(Types.TAG.getType(), tags, cid);
        metaService.saveMetas(Types.CATEGORY.getType(), categories, cid);
    }

    public void checkContent(ContentVo contentVo) {
        if (null == contentVo) {
            throw new TipException("文章对象不能为空");
        }
        if (null == contentVo.getTitle()) {
            throw new TipException("文章标题不能为空");
        }
        if (null == contentVo.getContent()) {
            throw new TipException("文章内容不能为空");
        }
        if (contentVo.getTitle().length() > 200) {
            throw new TipException("文章标题太长");
        }
        if (contentVo.getContent().length() > 65000) {
            throw new TipException("文章标题太长");
        }
        if (null == contentVo.getAuthorId()) {
            throw new TipException("请登录后发表文章");
        }
    }

}
