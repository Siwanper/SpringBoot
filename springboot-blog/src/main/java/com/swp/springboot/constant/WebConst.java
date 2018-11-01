package com.swp.springboot.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 常量
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-25 2:25 PM
 */
public class WebConst {

    public static Map<String, String> initConfig = new HashMap<>();

    public static final String LOGIN_SESSION_KEY = "login_user";
    public static final String LOGIN_ERROR_COUNT = "login_error_count";

    public static final String AES_SALT = "0123456789abcdef";
    public static final String USER_IN_COOKIE = "S_L_ID";

    /**
     * 点击次数超过多少更新到数据库
     */
    public static final int HIT_EXCEED = 10;

    public static final int MAX_POST_NUMBER = 9999;
}
