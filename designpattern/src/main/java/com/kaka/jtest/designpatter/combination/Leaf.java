package com.kaka.jtest.designpatter.combination;

/**
 * @author: jsk
 * @date: 2019/7/26 11:50
 */
public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation(String string) {
        System.out.println(string + "叶子:" + name);
    }

    @Override
    public boolean add(Component component) {
        throw new RuntimeException("叶子节点不支持此操作!");
    }

    @Override
    public boolean remove(Component component) {
        throw new RuntimeException("叶子节点不支持此操作!");
    }

    @Override
    public Component getChild(int i) {
        throw new RuntimeException("叶子节点不支持此操作!");
    }
}
