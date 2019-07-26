package com.kaka.jtest.jdk.java.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: jsk
 * @date: 2019/6/13 16:32
 */
public class BigDecimalTest {

    @Test
    public void testDouble() {
        double num1 = 1.1;
        double num2 = 2.2;
        System.out.println(num1 + num2);
    }

    /**
     * 1.public BigDecimal(double val)    将double表示形式转换为BigDecimal *不建议使用
     * 2.public BigDecimal(int val)　　将int表示形式转换成BigDecimal
     * 3.public BigDecimal(String val)　　将String表示形式转换成BigDecimal
     */
    @Test
    public void constructTest() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BigDecimal bDouble = new BigDecimal(2.3);
        BigDecimal bString = new BigDecimal("2.3");
        System.out.println("bigDecimal=" + bigDecimal);
        System.out.println("bDouble=" + bDouble);
        System.out.println("bString=" + bString);

        BigDecimal bDouble2 = new BigDecimal(Double.toString(2.3));
        System.out.println("bDouble2=" + bDouble2);
    }

    @Test
    public void valueOf() {
        BigDecimal bDouble1 = BigDecimal.valueOf(2.3);
        BigDecimal bDouble2 = new BigDecimal(Double.toString(2.3));

        System.out.println("bDouble1=" + bDouble1);
        System.out.println("bDouble2=" + bDouble2);
    }

    /**
     * 减乘除其实最终都返回的是一个新的BigDecimal对象，因为BigInteger与BigDecimal都是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象
     */
    @Test
    public void operation() {
        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");

        System.out.println("a + b =" + a.add(b));
        System.out.println("a - b =" + a.subtract(b));
        System.out.println("a * b =" + a.multiply(b));
        System.out.println("a / b =" + a.divide(b));
    }

    @Test
    public void abs(){
        BigDecimal a = new BigDecimal("-4.5");
        System.out.println(a.abs());
    }

    /**
     * BigDecimal除法可能出现不能整除的情况，比如 4.5/1.3，这时会报错java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
     * <p>
     * 其实divide方法有可以传三个参数
     * public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
     * 第一参数表示除数， 第二个参数表示小数点后保留位数，
     * 第三个参数表示舍入模式，只有在作除法运算或四舍五入时才用到舍入模式，八种舍入模式解释如下
     * 1、ROUND_UP
     * 舍入远离零的舍入模式。在丢弃非零部分之前始终增加数字(始终对非零舍弃部分前面的数字加1)。
     * 注意，此舍入模式始终不会减少计算值的大小。
     *
     * 2、ROUND_DOWN
     * 接近零的舍入模式。在丢弃某部分之前始终不增加数字(从不对舍弃部分前面的数字加1，即截短)。
     * 注意，此舍入模式始终不会增加计算值的大小。
     *
     * 3、ROUND_CEILING
     * 接近正无穷大的舍入模式。
     * 如果 BigDecimal 为正，则舍入行为与 ROUND_UP 相同;
     * 如果为负，则舍入行为与 ROUND_DOWN 相同。
     * 注意，此舍入模式始终不会减少计算值。
     *
     * 4、ROUND_FLOOR
     * 接近负无穷大的舍入模式。
     * 如果 BigDecimal 为正，则舍入行为与 ROUND_DOWN 相同;
     * 如果为负，则舍入行为与 ROUND_UP 相同。
     * 注意，此舍入模式始终不会增加计算值。
     *
     * 5、ROUND_HALF_UP
     * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。
     * 如果舍弃部分 >= 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同。
     * 注意，这是我们大多数人在小学时就学过的舍入模式(四舍五入)。
     *
     * 6、ROUND_HALF_DOWN
     * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为上舍入的舍入模式。
     * 如果舍弃部分 > 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同(五舍六入)。
     *
     * 7、ROUND_HALF_EVEN
     * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
     * 如果舍弃部分左边的数字为奇数，则舍入行为与 ROUND_HALF_UP 相同;
     * 如果为偶数，则舍入行为与 ROUND_HALF_DOWN 相同。
     * 注意，在重复进行一系列计算时，此舍入模式可以将累加错误减到最小。
     * 此舍入模式也称为“银行家舍入法”，主要在美国使用。四舍六入，五分两种情况。
     * 如果前一位为奇数，则入位，否则舍去。
     * 以下例子为保留小数点1位，那么这种舍入方式下的结果。
     *
     * 1.15>1.2 1.25>1.2
     *
     * 8、ROUND_UNNECESSARY
     * 断言请求的操作具有精确的结果，因此不需要舍入。
     * 如果对获得精确结果的操作指定此舍入模式，则抛出ArithmeticException。
     * <p>
     * ROUND_CEILING    //向正无穷方向舍入
     * ROUND_DOWN    //向零方向舍入
     * ROUND_FLOOR    //向负无穷方向舍入
     * ROUND_HALF_DOWN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5
     * ROUND_HALF_EVEN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP，如果是偶数，使用ROUND_HALF_DOWN
     * ROUND_HALF_UP    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6    (四舍五入用这个)
     * ROUND_UNNECESSARY    //计算结果是精确的，不需要舍入模式
     * ROUND_UP    //向远离0的方向舍入
     */
    @Test
    public void divideTest() {
        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.3");
        System.out.println("a / b =" + a.divide(b, 3, BigDecimal.ROUND_HALF_DOWN));
    }

    @Test
    public void setScale() {
        BigDecimal a = new BigDecimal("4.5635");
        //保留3位小数，且四舍五入
        a = a.setScale(3, RoundingMode.HALF_UP);
        System.out.println(a);
    }

}
