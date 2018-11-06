package com.swp.springboot.service.impl;

import com.swp.springboot.dao.AttachVoMapper;
import com.swp.springboot.modal.vo.AttachVo;
import com.swp.springboot.service.IAttachService;
import com.swp.springboot.util.DateKit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 * 附件上传服务
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-11-03 10:11 AM
 */
@Service
public class AttachServiceImpl implements IAttachService {

    @Resource
    private AttachVoMapper mapper;

    @Override
    public void save(String filename, String fkey, String ftype, Integer uid) {
        AttachVo attachVo = new AttachVo();
        attachVo.setAuthorId(uid);
        attachVo.setCreated(DateKit.getCurrentUnixTime());
        attachVo.setFkey(fkey);
        attachVo.setFtype(ftype);
        attachVo.setFname(filename);
        mapper.insert(attachVo);
    }
}
