package com.kaka.jtest.openutils.sf.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * json-lib   2010.12最新包
 *
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-28 16:55
 */
public class JSONObjectTest {

    /**
     * 列出所有key
     */
    @Test
    public void names(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key01", "value");
        JSONArray names = jsonObject.names();
        System.out.println(names);
    }

    @Test
    public void isNullObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key01", "value");
        JSONObject detail = jsonObject.getJSONObject("123");
        if (detail == null) {
            System.out.println("detail   不会为null");
            detail = new JSONObject();
        }
        System.out.println("detail:" + detail);
        System.out.println(detail.isNullObject());

        // nullObject不能put
        detail.put("key", "v");
        System.out.println(detail.isNullObject());
    }

}
