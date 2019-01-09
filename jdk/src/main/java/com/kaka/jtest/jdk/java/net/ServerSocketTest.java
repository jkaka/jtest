package com.kaka.jtest.jdk.java.net;

import org.junit.Test;

/**
 * @author jsk
 * @Date 2018/12/12 13:00
 */
public class ServerSocketTest {

    @Test
    public void serverStart() throws Exception {
        BioServer.start();
    }

    @Test
    public void clientStart() throws Exception {
        BioClient.send("贾双凯");
    }
}
