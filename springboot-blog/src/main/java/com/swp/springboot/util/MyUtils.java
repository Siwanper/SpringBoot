package com.swp.springboot.util;

import com.swp.springboot.constant.WebConst;
import com.swp.springboot.modal.vo.UserVo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


}
