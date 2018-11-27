package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/11/19 19:17
 */
public class ObjectTypeTest {
    /**
     * 强制转换
     */
    @Test
    public void castingTest() {
        Map<String, Object> map = new HashMap() {{
            put("aa", "aa");
        }};
        String a = (String) map.get("bb");
        System.out.println(a);
    }
}
