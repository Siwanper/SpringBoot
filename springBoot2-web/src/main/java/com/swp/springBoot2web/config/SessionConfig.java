package com.swp.springBoot2web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 描述:
 * session 缓存配置
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-20 上午11:40
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {

}
