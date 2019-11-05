package com.kaka.jtest.jdk.java.awt;

import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-04 15:22
 */
public class DesktopTest {
    @Test
    public void open() throws IOException {
        Desktop.getDesktop().open(new File("/home"));
    }
}
