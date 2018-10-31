package com.swp.springboot.service.impl;

import com.swp.springboot.constant.WebConst;
import com.swp.springboot.dao.MetaVoMapper;
import com.swp.springboot.dto.MetaDto;
import com.swp.springboot.exception.TipException;
import com.swp.springboot.modal.vo.MetaVo;
import com.swp.springboot.modal.vo.MetaVoExample;
import com.swp.springboot.service.IContentService;
import com.swp.springboot.service.IMetaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 分类和标签业务
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-31 3:19 PM
 */
@Service
public class MetaServiceImpl implements IMetaService {

    @Resource
    private IContentService contentService;

    @Resource
    private MetaVoMapper metaVoMapper;

    @Override
    public void saveMeta(String type, String name, Integer mid) {
        if (StringUtils.isBlank(type)) {
            throw new TipException("类型不能为空");
        }
        if (StringUtils.isBlank(name)) {
            throw new TipException("名称不能为空");
        }
        MetaVoExample example = new MetaVoExample();
        MetaVoExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name).andTypeEqualTo(type);
        List<MetaVo> metaVos = metaVoMapper.selectByExample(example);
        if (metaVos.size() != 0) {
            throw new TipException("改标签已经存在");
        }else {
            MetaVo metaVo = new MetaVo();
            metaVo.setName(name);
            if (null != mid) {
                MetaVo original = metaVoMapper.selectByPrimaryKey(mid);
                metaVo.setMid(mid);
                metaVoMapper.updateByPrimaryKeySelective(metaVo);

                // 更新原有文章中的category
                contentService.updateCategory(original.getName(),name);
            } else {
                metaVo.setType(type);
                metaVoMapper.insert(metaVo);
            }
        }

    }

    @Override
    public List<MetaDto> getMetaList(String type, String order, int limit) {
        if (StringUtils.isNotBlank(type)) {
            if (StringUtils.isBlank(order)) {
                order = "count, a.mid";
            }
            if (limit < 1 || limit > WebConst.MAX_POST_NUMBER){
                limit = 10;
            }
            Map<String, Object> map = new HashMap();
            map.put("type", type);
            map.put("order", order);
            map.put("limit", limit);
            return metaVoMapper.selectFromSql(map);
        }
        return null;
    }
}
