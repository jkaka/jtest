package com.kaka.jtest.designpatter.state.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/28 12:20
 */
public class NidaleeClient {
    public static void main(String[] args) {
        Nidalee nidalee = new Nidalee();
        nidalee.skillQ();

        nidalee.skillR();
        nidalee.skillQ();
        nidalee.skillW();

        nidalee.skillR();
        nidalee.skillQ();
        nidalee.skillW();
    }
}
