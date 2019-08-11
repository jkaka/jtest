package com.kaka.jtest.designpatter.chain.exmaple;

/**
 * 投诉类
 *
 * @author: jsk
 * @date: 2019/8/11 13:34
 */
public class Complain {
    private String type;
    private String message;

    public Complain(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
