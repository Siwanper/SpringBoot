package com.swp.springBoot2web.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2018-09-20 上午11:33
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{

}
