package com.swp.springboot.service;

public interface IAttachService {

    /**
     * 保存附件
     * @param filename
     * @param fkey
     * @param ftype
     * @param uid
     */
    void save(String filename, String fkey, String ftype, Integer uid);

}
