package com.kaka.jtest.jdk.java.util.jar;

import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author: jsk
 * @date: 2019/4/4 15:45
 */
public class JarFileTest {


    @Test
    public void entries() throws Exception {
        String path = "D:\\localRepository\\com\\jsk\\spring\\boot\\jsk-spring-boot-autoconfigure\\1.0.4-SNAPSHOT\\jsk-spring-boot-autoconfigure-1.0.4-SNAPSHOT.jar";
        JarFile localJarFile = new JarFile(new File(path));

        Enumeration<JarEntry> entries = localJarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            System.out.println(jarEntry.getName());
            /*String innerPath = jarEntry.getName();
            if(innerPath.startsWith("conf")){
                InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(innerPath);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line="";
                while((line=br.readLine())!=null){
                    System.out.println(innerPath+"内容为:"+line);
                }
            }*/
        }
    }
}
