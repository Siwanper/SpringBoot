package com.swp.springBoot2web.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 描述:
 * 自定义过滤器
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-19 下午4:32
 */
public class MyFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter: init" + getClass());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("MyFilter: filter uri + "+ request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("MyFilter: destroy" + getClass());
    }
}
