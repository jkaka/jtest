package com.kaka.jtest.designpatter.state;

/**
 * @author: jsk
 * @date: 2019/7/26 14:08
 */
public class StateClient {
    public static void main(String[] args) {
        Context con = new Context();
        con.request();
        con.request();
        con.request();
        con.request();
        con.request();
        con.request();
    }
}
