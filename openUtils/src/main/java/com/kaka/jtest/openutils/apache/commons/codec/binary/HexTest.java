package com.kaka.jtest.openutils.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-19 09:46
 */
public class HexTest {

    @Test
    public void methodName() {
        String str = Hex.encodeHexString("中国".getBytes());
        System.out.println(str);
    }
}
