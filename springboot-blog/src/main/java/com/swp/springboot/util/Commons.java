package com.swp.springboot.util;

import com.swp.springboot.constant.WebConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 统一链接处理
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-30 11:20 AM
 */

@Component
public class Commons {

    public static String gravatar(String email) {
        String avatarUrl = "https://secure.gravatar.com/avatar";
        if (StringUtils.isBlank(email)) {
            return avatarUrl;
        }
        String hash = MyUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + "/" + hash;
    }

    /**
     * 网站链接
     *
     * @return
     */
    public static String site_url(){
        return site_url("/page/1");
    }

    /**
     * 返回网站链接下的全地址
     *
     * @param sub 后面追加的地址
     * @return
     */
    public static String site_url(String sub) {
        return site_option("site_url", sub);
    }

    /**
     * 网站配置项
     *
     * @param key
     * @return
     */
    public static String site_option(String key) {
        return site_option(key);
    }

    /**
     * 网站配置项
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String site_option(String key, String defaultValue) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        String str = WebConst.initConfig.get(key);
        if (StringUtils.isNotBlank(str)) {
            return str;
        } else {
            return defaultValue;
        }
    }

    /**
     * 格式化unix时间戳为日期
     *
     * @param unixTime
     * @return
     */
    public static String fmtdata(Integer unixTime){
        return fmtdate(unixTime, "yyyy-MM-dd");
    }

    /**
     * 格式化unix时间戳为日期
     *
     * @param unixTime
     * @param patten
     * @return
     */
    public static String fmtdate(Integer unixTime, String patten) {
        if (null != unixTime && StringUtils.isNotBlank(patten)) {
            return DateKit.formatDateByUnixTime(unixTime, patten);
        }
        return "";
    }
}
