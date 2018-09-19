package com.swp.springBoot2web;

import com.swp.springBoot2web.filters.MyFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * 页面配置
 * 自定义Filter
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-19 下午4:17
 */
@Configuration
public class WebConfiguration {

    //需要将代理服务器发来的请求包含的IP地址转换成真正的用户IP
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    // 添加自定义过滤器
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(myFilter()); // 设置过滤器
        registrationBean.addUrlPatterns("/*"); // 设置过滤的内容
        registrationBean.addInitParameter("paramName","paramValue");
        registrationBean.setName("MyFilter"); // 设置过滤器名称
        registrationBean.setOrder(1); // 设置过滤器顺序
        return registrationBean;
    }

    @Bean
    public MyFilter myFilter(){
        return new MyFilter();
    }
}
