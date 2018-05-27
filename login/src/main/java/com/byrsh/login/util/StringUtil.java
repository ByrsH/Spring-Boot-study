package com.byrsh.login.util;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 17:46 2018/5/27
 * @Modified By:
 */
public class StringUtil {
    private StringUtil() {
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}
