package com.kaka.jtest.designpatter.chain.exmaple;

/**
 * 脏话处理器
 *
 * @author: jsk
 * @date: 2019/8/11 13:12
 */
public class BadLanguageHandler extends AbstractComplaintHandler {
    public BadLanguageHandler(AbstractComplaintHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handlerRequest(Complain complain) {
        System.out.println("【脏话】处理器开始处理...");
        if ("脏话".equals(complain.getType())) {
            // 模拟检测脏话
            if (new Double(Math.random() * 100).intValue() % 2 == 0) {
                System.out.println("系统检测到本场比赛,没有玩家脏话！");
                System.out.println("-------------------------------------");
                return;
            } else {
                System.out.println("本场游戏确实存在辱骂行为,交由后面人工审核！");
            }
        } else {
            System.out.println("投诉类型不是【脏话】,交由后面的处理器处理！");
        }
        this.getNextHandler().handlerRequest(complain);
        System.out.println("-------------------------------------");
    }
}
