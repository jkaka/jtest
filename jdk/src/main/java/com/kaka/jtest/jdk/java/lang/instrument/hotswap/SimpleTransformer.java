package com.kaka.jtest.jdk.java.lang.instrument.hotswap;

import java.io.File;
import java.io.FileInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author: jsk
 * @date: 2019/4/3 15:34
 */
public class SimpleTransformer implements ClassFileTransformer {
    private final String filePath;
    private final String className;

    SimpleTransformer(String filePath, String className) {
        super();
        this.filePath = filePath;
        this.className = className;
    }

    /**
     *
     * @param loader
     * @param className  注意:这个是类的全路径,不是全类名
     * @param classBeingRedefined
     * @param protectionDomain
     * @param classfileBuffer
     * @return
     * @throws IllegalClassFormatException
     */
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals(this.className)) {
            return null;
        }
        System.out.println(String.format("ready to replace class=%s", className));
        return SimpleHelper.file2bytes(filePath);
    }
}

class SimpleHelper {
    static byte[] file2bytes(String filePath) {
        File file = new File(filePath);
        long len = file.length();
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bs = new byte[(int) len];
            int num = fis.read(bs);
            System.out.println(String.format("read num=%d", num));
            return bs;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}