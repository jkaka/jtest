package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import javax.xml.transform.Templates;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 一个桶中的元素数量大于8个时，使用红黑树而不是链表
 *
 * 在resize的过程中，如果桶中的元素小于6个，将树转换为链表
 *
 * 只有hashmap容量大于64时，才可以树化
 * @author: jsk
 * @date: 2019/8/28 13:57
 */
public class HashMapTest {

    /**
     * size代表map中数据的个数,不是容量
     */
    @Test
    public void sizeTest(){
        Map<String, String> map = new HashMap<>(16);
        map.put("abc", "a");
        System.out.println(map.size());
    }

    /**
     * 循环体中调用新增、删除key  都会报错
     */
    @Test
    public void removeFailure(){
        Map<String, String> map = new HashMap<>(16);
        map.put("abc", "a");
        map.put("aa", "a");
        Set<String> keyList = map.keySet();
        for (String key : keyList) {
            map.remove(key);
        }
    }

    /**
     * 使用iterator的remove方法，即可正常删除
     */
    @Test
    public void removeSuccess(){
        Map<String, String> map = new HashMap<>(16);
        map.put("aa", "1");
        map.put("bb", "2");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            if("aa".equals(key)){
                System.out.println("To delete key:" + key);
                it.remove();
                System.out.println("The key:" + key + " was deleted");
            }
        }
        System.out.println(map);
    }

    /**
     * 使用entrySet的removeIf方法
     */
    @Test
    public void removeSuccess2(){
        Map<String, String> map = new HashMap<>(16);
        map.put("aa", "1");
        map.put("bb", "2");
        map.entrySet().removeIf(next -> {
            System.out.println("To delete key:" + next.getKey());
            return "aa".equals(next.getKey());
        });
        System.out.println(map);
    }

}
