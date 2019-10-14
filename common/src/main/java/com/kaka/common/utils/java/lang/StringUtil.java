package com.kaka.common.utils.java.lang;

import org.springframework.util.StringUtils;

/**
 * @author jsk
 * @Date 2018/10/31 14:32
 */
public class StringUtil {
    private static String SEPARATOR_CHARS = "_";

    /**
     * 下划线命名转为驼峰命名
     *
     * @param string
     * @return
     */
    public static String underlineToHump(String string) {
        if (StringUtils.isEmpty(string)) {
            return string;
        }
        String[] stringArray = StringUtils.split(string, SEPARATOR_CHARS);

        StringBuilder stringBuilder = new StringBuilder(lowerCaseFirst(stringArray[0]));
        for (int i = 1; i < stringArray.length; i++) {
            stringBuilder.append(upperCaseFirst(stringArray[i]));
        }
        return stringBuilder.toString();
    }

    /**
     * 驼峰命名转为下划线命名
     *
     * @param string
     * @return
     */
    public static String humpToUnderline(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        // 已经添加下划线的个数
        int num = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                stringBuilder.insert(i + num, "_");
                num += 1;
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 首字母大写
     *
     * @param name
     * @return
     */
    public static String upperCaseFirst(String name) {
        if (StringUtils.isEmpty(name)) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * 首字母小写
     *
     * @param name
     * @return
     */
    public static String lowerCaseFirst(String name) {
        if (StringUtils.isEmpty(name)) {
            return name;
        }
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(humpToUnderline("abaCnnDdfdfdDDDsssss"));
    }
}
