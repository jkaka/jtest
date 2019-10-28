package com.kaka.jtest.openutils.sf.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * JSONArray其实是一个List
 *
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-28 16:58
 */
public class JSONArrayTest {

    @Test
    public void getString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key01", "value");
        JSONArray jsonArray = jsonObject.names();
        System.out.println(jsonArray.getString(0));
    }

}
