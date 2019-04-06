package com.kaka.jtest.jdk.java.util.jar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.regex.Matcher;

/**
 * @author: jsk
 * @date: 2019/4/4 9:58
 */
public class JarOutputStreamTest {

    public static void main(String[] args) throws Exception {
        createJar(JarOutputStreamTest.class);
    }

    /**
     * 动态生成Jar包
     */
    public static File createJar(Class<?> clazz) throws Exception {
        String clsName = clazz.getName();
        String base = clsName.substring(0, clsName.lastIndexOf("."));
        base = base.replaceAll("\\.", Matcher.quoteReplacement("/"));
        URL root = clazz.getResource("");

        JarOutputStream out = null;
        final File jar = File.createTempFile("storm-", ".jar", new File(System.getProperty("java.io.tmpdir")));
        System.out.println(jar.getAbsolutePath());
        //运行完成后删除jar包
        Runtime.getRuntime().addShutdownHook(new Thread(jar::delete));
        try {
            File path = new File(root.toURI());
            Manifest manifest = new Manifest();
            manifest.getMainAttributes().putValue("Manifest-Version", "1.0");
            manifest.getMainAttributes().putValue("Created-By", "JarPackageUtil");
            out = new JarOutputStream(new FileOutputStream(jar), manifest);
            writeBaseFile(out, path, base);
        } finally {
            out.flush();
            out.close();
        }
        return jar;
    }

    /**
     * 递归添加.class文件
     */
    private static void writeBaseFile(JarOutputStream out, File file, String base) throws IOException {
        if (file.isDirectory()) {
            File[] fl = file.listFiles();
            if (base.length() > 0) {
                base = base + "/";
            }
            for (int i = 0; i < fl.length; i++) {
                writeBaseFile(out, fl[i], base + fl[i].getName());
            }
        } else {
            out.putNextEntry(new JarEntry(base));
            FileInputStream in = null;
            try {
                in = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int n = in.read(buffer);
                while (n != -1) {
                    out.write(buffer, 0, n);
                    n = in.read(buffer);
                }
            } finally {
                in.close();
            }
        }
    }
}
