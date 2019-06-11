package com.kaka.jtest.jdk.java.lang.instrument.hotswap;

import java.io.File;
import java.io.FileInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Transformer实现了ClassFileTransformer接口，该接口只有一个transform方法，
 * 参数传入包括该类的类加载器，类名，原字节码字节流等，返回被转换后的字节码字节流。
 *   当方法返回后，Java虚拟机会使用所返回的byte数组，来完成接下来的类加载工作；返回null或者抛出异常，
 * 那么Java虚拟机将使用原来的byte数组完成类加载工作。
 *
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
     * @param loader 将被转换的类的类装载器，如果是启动类装载器则此参数可以为空；
     * @param className 类名字，不过这是JVM规范定义的全限名字如java/util/List
     * @param classBeingRedefined
     * @param protectionDomain 保护域，跟安全有关；
     * @param classfileBuffer 这个便是被代理类字节码流，正是通过操作这个buffer完成对字节码的修改；
     * @return 如果返回null，则表示不对类的字节码做任何的修改，否则应该返回修改过的byte[]对象。
     */
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer){
        // 简单的判断是否是 要进行转换的类,
        // 如果不是,  返回 null ，应该是表示不进行转换的 意思
        // 如果是, 则使用新的类定义文件 进行替换
        // 复杂一些的逻辑 可以使用 字节码技术 在原来的基础上进行更改
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