package com.kaka.jtest.designpatter.combination.exmaple;

import java.util.List;

/**
 * 好友分组
 *
 * @author: jsk
 * @date: 2019/7/27 13:17
 */
public class FriendMenu extends FriendComponent {

    private String name;
    private List<FriendComponent> friendComponentList;

    public FriendMenu(String name, List<FriendComponent> friendComponentList) {
        this.name = name;
        this.friendComponentList = friendComponentList;
    }

    @Override
    boolean add(FriendComponent friendComponent) {
        return friendComponentList.add(friendComponent);
    }

    @Override
    boolean remove(FriendComponent friendComponent) {
        return friendComponentList.remove(friendComponent);
    }

    @Override
    FriendComponent getChild(int i) {
        return friendComponentList.get(i);
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + name);
        for (FriendComponent friendComponent : friendComponentList) {
            friendComponent.print(prefix + "\t");
        }
    }
}
