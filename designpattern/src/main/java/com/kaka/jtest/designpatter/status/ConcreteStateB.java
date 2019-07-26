package com.kaka.jtest.designpatter.status;

/**
 * @author: jsk
 * @date: 2019/7/26 13:56
 */
public class ConcreteStateB implements State {

    private Context context;

    public ConcreteStateB(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println("B动作执行,切换为A状态");
        context.setCurrentStat(context.getStateA());
    }
}
