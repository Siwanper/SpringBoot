package com.swp.springboot.util;

import org.springframework.stereotype.Component;

/**
 * 描述:
 * 管理员
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-30 11:23 AM
 */
@Component
public class AdminCommons {
    private static final String[] COLORS = {"jantent", "primary", "success", "info", "warning", "danger", "inverse", "purple", "pink"};

    public static String rand_color() {
        int r = Tools.rand(0, COLORS.length - 1);
        return COLORS[r];
    }
}
