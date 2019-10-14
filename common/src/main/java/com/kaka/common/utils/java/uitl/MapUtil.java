package com.kaka.common.utils.java.uitl;

import com.kaka.common.utils.java.lang.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/12/3 20:34
 */
public class MapUtil {

    /**
     * 键名由驼峰转下划线
     *
     * @param map
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> keyHumpToUnderline(Map<String, T> map) {
        Map<String, T> stringTMap = new HashMap<>(16);
        for (String string : map.keySet()) {
            stringTMap.put(StringUtil.humpToUnderline(string), map.get(string));
        }
        return stringTMap;
    }

    /**
     * key 由下划线转驼峰
     *
     * @param map
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> keyUnderlineToHump(Map<String, T> map) {
        Map<String, T> stringTMap = new HashMap<>(16);
        for (String string : map.keySet()) {
            stringTMap.put(StringUtil.underlineToHump(string), map.get(string));
        }
        return stringTMap;
    }
}
