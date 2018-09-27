package com.swp.rabbitmq.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * rabbit基本配置
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-26 下午2:58
 */

@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue many(){
        return new Queue("many");
    }

    @Bean
    public Queue object(){
        return new Queue("object");
    }

}
