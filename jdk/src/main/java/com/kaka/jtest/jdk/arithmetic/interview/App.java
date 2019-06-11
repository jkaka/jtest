package com.kaka.jtest.jdk.arithmetic.interview;

/**
 * @author: jsk
 * @date: 2019/6/5 20:40
 */
public class App {
    public static void main(String[] args) {

    }
}
class Account{
    private double money;
    private String accountName;

    public Account(double money, String accountName) {
        this.money = money;
        this.accountName = accountName;
    }

    public boolean saveMoney(Account account, double money){
        if((this.money + money) > 1000){
        }
        this.money += money;
        return true;
    }

    public boolean drawMoney(Account account, double money){
        this.money += money;
        return true;
    }
}
