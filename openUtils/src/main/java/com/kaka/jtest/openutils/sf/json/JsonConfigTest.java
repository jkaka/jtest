package com.kaka.jtest.openutils.sf.json;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-28 17:13
 */
public class JsonConfigTest {


    /**
     * 默认过滤的key："class", "declaringClass", "metaClass"
     * {@link JsonConfig} DEFAULT_EXCLUDES
     */
    @Test
    public void setIgnoreDefaultExcludes() {
        Map<String, String> map = new HashMap<>(8);
        map.put("name", "json");
        map.put("class", "ddd");
        JsonConfig config = new JsonConfig();
        // 默认为false，即过滤默认的key
        config.setIgnoreDefaultExcludes(true);
        JSONObject jsonObject = JSONObject.fromObject(map, config);
        System.out.println(jsonObject);
    }
}
