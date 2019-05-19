package com.kaka.jtest.openutils.disruptor.event;

/**
 * @author: jsk
 * @date: 2019/5/1 10:34
 */
public class MyInParkingDataEvent {

    private String carLicense; // 车牌号

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

}