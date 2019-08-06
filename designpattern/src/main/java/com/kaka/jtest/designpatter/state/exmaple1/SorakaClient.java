package com.kaka.jtest.designpatter.state.exmaple1;

/**
 * @author: jsk
 * @date: 2019/7/27 15:06
 */
public class SorakaClient {

    public static void main(String[] args) {
        Soraka soraka = new Soraka(130, 320);
        soraka.skillW();
        soraka.skillW();
        soraka.skillW();
        soraka.addRed(200);
        soraka.skillW();
        soraka.skillW();
        soraka.addBlue(300);
        soraka.skillW();
        soraka.skillW();
    }
}
