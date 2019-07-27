package com.kaka.jtest.designpatter.combination.exmaple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jsk
 * @date: 2019/7/27 13:17
 */
public class FriendClient {
    public static void main(String[] args) {
        FriendMenu friendMenu = initFriend();
        // 打印好友列表信息
        friendMenu.print("");
    }

    private static FriendMenu initFriend() {
        // 1.创建不同组的好友
        List<FriendComponent> highSchoolFriendList = new ArrayList<>();
        FriendMenu highSchoolFriendMenu = new FriendMenu("【高中同学】", highSchoolFriendList);
        highSchoolFriendMenu.add(new FriendItem("一根烟的温柔"));
        highSchoolFriendMenu.add(new FriendItem("匆匆那年灬亚楠"));
        highSchoolFriendMenu.add(new FriendItem("匆匆那年灬淇少"));
        highSchoolFriendMenu.add(new FriendItem("匆匆那年灬普少"));

        // 直接创建含有数据的list
        List<FriendComponent> universityFriendList = new ArrayList<FriendComponent>() {{
            add(new FriendItem("猛虎之坑王之王"));
            add(new FriendItem("32号嫁给你傲"));
            add(new FriendItem("32号嫁给你晨"));
            add(new FriendItem("32号嫁给你乐"));
        }};
        FriendMenu universityFriendMenu = new FriendMenu("【大学同学】", universityFriendList);

        // 2.合并组(在同学分组中添加"分组")
        List<FriendComponent> friendList = new ArrayList<FriendComponent>() {{
            add(highSchoolFriendMenu);
            add(universityFriendMenu);
        }};
        FriendMenu friendMenu = new FriendMenu("【同学】", friendList);
        // 在同学分组中添加"好友"
        friendMenu.add(new FriendItem("木叶小鬼"));
        friendMenu.add(new FriendItem("希望不排队"));
        return friendMenu;
    }
}
