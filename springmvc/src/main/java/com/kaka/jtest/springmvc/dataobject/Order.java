package com.kaka.jtest.springmvc.dataobject;

/**
 * @author jsk
 * @Date 2018/8/21 9:30
 */
public class Order {
    private Integer id;
    private String orderCode;
    private Goods goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", goods=" + goods +
                '}';
    }
}
