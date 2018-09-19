package com.swp.springBoot2web.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 自定义属性
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-19 下午5:21
 */

@Component
public class MyProperties {

    @Value("${com.swp.title}")
    private String title;
    @Value("${com.swp.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
