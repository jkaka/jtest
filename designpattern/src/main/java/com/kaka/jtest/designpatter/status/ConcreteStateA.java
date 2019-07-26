package com.kaka.jtest.designpatter.status;

/**
 * @author: jsk
 * @date: 2019/7/26 13:55
 */
public class ConcreteStateA implements State {

    private Context context;

    public ConcreteStateA(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println("A动作执行,切换为B状态");
        context.setCurrentStat(context.getStateB());
    }
}
