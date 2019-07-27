package com.kaka.jtest.designpatter.combination.exmaple;

/**
 * 好友信息
 *
 * @author: jsk
 * @date: 2019/7/27 13:16
 */
public class FriendItem extends FriendComponent {

    private String name;

    public FriendItem(String name) {
        this.name = name;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + name);
    }
}
