package com.kaka.jtest.designpatter.builder.nondirector;

/**
 * @author: jsk
 * @date: 2019/8/10 15:16
 */
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public Product(Builder builder) {
        partA = builder.partA;
        partB = builder.partB;
        partC = builder.partC;
    }

    public static class Builder{
        private String partA;
        private String partB;
        private String partC;

        public Builder(String partA) {
            this.partA = partA;
        }

        public Builder addPartB(String partB){
            this.partB = partB;
            return this;
        }
        public Builder addPartC(String partC){
            this.partC = partC;
            return this;
        }
        public Product build(){
            return new Product(this);
        }
    }
    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}
