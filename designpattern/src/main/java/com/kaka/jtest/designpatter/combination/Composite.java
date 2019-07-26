package com.kaka.jtest.designpatter.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jsk
 * @date: 2019/7/26 11:50
 */
public class Composite implements Component {
    private String name;
    private List<Component> componentList;

    public Composite(String name, List<Component> componentList) {
        this.name = name;
        this.componentList = componentList;
    }

    @Override
    public void operation(String string) {
        System.out.println(string +"组件:" + name);
        for (Component component : componentList) {
            component.operation(string + "\t");
        }
    }

    @Override
    public boolean add(Component component) {
        return componentList.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return componentList.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return componentList.get(i);
    }
}
