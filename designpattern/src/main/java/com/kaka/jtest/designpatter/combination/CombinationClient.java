package com.kaka.jtest.designpatter.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jsk
 * @date: 2019/7/26 12:06
 */
public class CombinationClient {
    public static void main(String[] args) {
        List<Component> list1 = new ArrayList<Component>(){{
            add(new Leaf("后代001"));
            add(new Leaf("后代002"));
            add(new Leaf("后代003"));
        }};

        List<Component> list2 = new ArrayList<Component>(){{
            add(new Leaf("后代006"));
            add(new Leaf("后代004"));
            add(new Leaf("后代005"));
        }};

        Composite composite1 = new Composite("组件001", list1);
        Composite composite2 = new Composite("组件002", list2);

        List<Component> list3 = new ArrayList<Component>(){{
            add(composite1);
            add(composite2);
        }};
        Composite composite3 = new Composite("组件003", list3);
        composite3.operation("");
    }
}
