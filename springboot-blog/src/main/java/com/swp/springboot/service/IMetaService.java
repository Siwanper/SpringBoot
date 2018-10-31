package com.swp.springboot.service;

import com.swp.springboot.dto.MetaDto;

import java.util.List;

public interface IMetaService {

    /**
     *  保存分类和标签
     *
     * @param type
     * @param name
     * @param mid
     */
    void saveMeta(String type, String name, Integer mid);

    /**
     * 获取分类和标签列表，包含文章个数
     *
     * @param type 分类或者标签
     * @param order 排序
     * @param limit
     * @return
     */
    List<MetaDto> getMetaList(String type, String order, int limit);

    /**
     * 删除分类或标签
     *
     * @param mid
     */
    void delete(Integer mid);
}
