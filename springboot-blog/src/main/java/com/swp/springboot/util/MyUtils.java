package com.swp.springboot.util;

import com.swp.springboot.constant.WebConst;
import com.swp.springboot.modal.vo.UserVo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 描述:
 * 工具类
 *
 * @outhor ios
 * @create 2018-10-25 2:22 PM
 */
public class MyUtils {

    /**
     * 获取登录的用户
     *
     * @param request
     * @return
     */
    public static UserVo getLoginUser(HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        UserVo user = (UserVo) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
        return user;
    }

    /**
     * MD5加密
     *
     * @param source
     * @return
     */
    public static String MD5encode(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bytes = messageDigest.digest(source.getBytes());
        StringBuffer hexString = new StringBuffer();
        for (byte anEncode : bytes) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * 设置记住密码的cookie
     * 十二小时
     * @param response
     * @param uid
     */
    public static void setCookie(HttpServletResponse response, Integer uid) {
        try {
            String val = Tools.enAes(uid.toString(), WebConst.AES_SALT);
            Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, val);
            cookie.setPath("/");
            cookie.setMaxAge(12 * 60 * 60);
            cookie.setSecure(false);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Integer getCookieUid(HttpServletRequest request) {
        if (null != request) {
            Cookie cookie = cookieRaw(WebConst.USER_IN_COOKIE, request);
            if (cookie != null && cookie.getValue() != null) {
                try {
                    String uid = Tools.deAes(cookie.getValue(), WebConst.AES_SALT);
                    return StringUtils.isNotBlank(uid) && Tools.isNumber(uid) ? Integer.parseInt(uid) : null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Cookie cookieRaw(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }

    public static String getUploadFilePath() {
        String path = MyUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.substring(1, path.length());
        try {
            path = URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int lastIndex = path.lastIndexOf("/") + 1;
        path = path.substring(0, lastIndex);
        File file = new File("");
        return file.getAbsolutePath() + "/";

    }
}
