package com.kaka.jtest.jdk.jvm.metaspace;

import java.util.ArrayList;
import java.util.List;

/**
 * 元空间的本质和永久代类似，都是对JVM规范中方法区的实现。
 * 不过元空间与永久代之间最大的区别在于：元空间并不在虚拟机中，而是使用本地内存。因此，默认情况下，元空间的大小仅受本地内存限制，但可以通过以下参数来指定元空间的大小：
 *
 * 　　-XX:MetaspaceSize，初始空间大小，达到该值就会触发垃圾收集进行类型卸载，同时GC会对该值进行调整：如果释放了大量的空间，就适当降低该值；
 * 如果释放了很少的空间，那么在不超过MaxMetaspaceSize时，适当提高该值。
 * 　　-XX:MaxMetaspaceSize，最大空间，默认是没有限制的。
 * 　　除了上面两个指定大小的选项以外，还有两个与 GC 相关的属性：
 * 　　-XX:MinMetaspaceFreeRatio，在GC之后，最小的Metaspace剩余空间容量的百分比，减少为分配空间所导致的垃圾收集
 * 　　-XX:MaxMetaspaceFreeRatio，在GC之后，最大的Metaspace剩余空间容量的百分比，减少为释放空间所导致的垃圾收集
 *
 *
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 * @author jsk
 * @Date 2019/1/28 19:32
 */
public class StringOomMock {
    static String  base = "string";
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}
