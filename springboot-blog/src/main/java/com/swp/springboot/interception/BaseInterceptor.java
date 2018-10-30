package com.swp.springboot.interception;

import com.swp.springboot.constant.WebConst;
import com.swp.springboot.modal.vo.UserVo;
import com.swp.springboot.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 * 拦截器
 *
 * @outhor ios
 * @create 2018-10-25 5:52 PM
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);
    private static final String USER_AGENT = "user-agent";

    private MapCache cache = MapCache.single();

    @Resource
    private Commons commons;

    @Resource
    private AdminCommons  adminCommons;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String ip = IpUtil.getIpAddrByRequest(request);
        logger.info("UserAgent: {}", request.getHeader(USER_AGENT));
        logger.info("用户访问地址: {}, 来路地址 {}", uri, ip);

        // 请求拦截处理
        UserVo user = MyUtils.getLoginUser(request);
        if (null == user) {
            Integer uid = MyUtils.getCookieUid(request);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
        }

        // 处理uri
        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && null == user) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }

        // TODO CSRF 处理

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO IP黑名单
        // TODO 统一链接处理

        request.setAttribute("commons", commons);
        request.setAttribute("adminCommons", adminCommons);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
