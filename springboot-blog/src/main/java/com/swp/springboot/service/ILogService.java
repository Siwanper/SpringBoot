package com.swp.springboot.service;

public interface ILogService {

    /**
     * 保存log
     *
     * @param action
     * @param data
     * @param authorId
     * @param ip
     */
    public void insertLog(String action, String data, Integer authorId, String ip);

}
