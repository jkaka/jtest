package com.kaka.jtest.springboot.common.utils.jvm;

/**
 * @author: jsk
 * @date: 2019/3/25 20:32
 */
public class HotSpotClassLoader extends ClassLoader {
    public HotSpotClassLoader() {
        super(HotSpotClassLoader.class.getClassLoader());
    }

    public Class loadByte(String name, byte[] bytes){
        return defineClass(name, bytes, 0, bytes.length);
    }
}
