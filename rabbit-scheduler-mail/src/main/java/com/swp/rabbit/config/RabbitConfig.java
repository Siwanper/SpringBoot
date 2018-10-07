package com.swp.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * RabbitMQ配置文件
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-28 10:59 AM
 */
@Configuration
public class RabbitConfig {

    // 注册发送邮件的队列
    @Bean
    public Queue mailQueue(){
        return new Queue("mailQueue");
    }

}
