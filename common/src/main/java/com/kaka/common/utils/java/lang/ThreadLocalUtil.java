package com.kaka.common.utils.java.lang;

/**
 * @author jsk
 * @Date 2018/12/7 12:06
 */
public class ThreadLocalUtil {
    private static final ThreadLocal<String> userNameThreadLocal = new ThreadLocal<>();

    public static String getUserName() {
        return userNameThreadLocal.get();
    }

    public static void setUserName(String userName) {
        userNameThreadLocal.set(userName);
    }

    public static void removeUserName() {
        userNameThreadLocal.remove();
    }
}
