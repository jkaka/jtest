package com.kaka.jtest.jdk.arithmetic.interview;

/**
 * @author: jsk
 * @date: 2019/6/5 21:41
 */
public class Main {
    public static void main (String[] str){
        System.out.println(getN(8));
    }

    public static Long getN(long n){
        if(n < 0){
            throw new RuntimeException("不能输入负数");
        }
        if(n == 0 || n==1)
            return 1L;

        for(int i = 1; i <= n; i ++){
            n *= i;
        }
        return n;
    }


    public static Long getN1(long n){
        if(n < 0){
            throw new RuntimeException("不能输入负数");
        }
        if(n > 1){
            n *= getN1(n -1);
        }else{
            return 1L;
        }
        return n;
    }
}
