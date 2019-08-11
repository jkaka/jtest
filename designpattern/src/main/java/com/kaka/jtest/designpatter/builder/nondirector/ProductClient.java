package com.kaka.jtest.designpatter.builder.nondirector;

/**
 * @author: jsk
 * @date: 2019/8/10 15:35
 */
public class ProductClient {

    public static void main(String[] args) {
        Product product = new Product.Builder("A")
                .addPartB("B")
                .addPartC("C")
                .build();
        System.out.println(product);
    }
}
