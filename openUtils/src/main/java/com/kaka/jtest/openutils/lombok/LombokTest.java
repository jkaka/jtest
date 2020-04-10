package com.kaka.jtest.openutils.lombok;

import com.kaka.jtest.openutils.lombok.beans.Ant;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/04/02 14:26:41
 */
public class LombokTest {

    @Test
    public void myMethod(){
        Ant ant = new Ant();
        ant.setId(2);
        System.out.println(ant);
    }
}
