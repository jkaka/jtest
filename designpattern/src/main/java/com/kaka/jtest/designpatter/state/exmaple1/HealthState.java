package com.kaka.jtest.designpatter.state.exmaple1;

/**
 * @author: jsk
 * @date: 2019/7/27 14:44
 */
public class HealthState implements SorakaState {
    private Soraka soraka;

    public HealthState(Soraka soraka) {
        this.soraka = soraka;
    }

    @Override
    public void addRed(int num) {
        soraka.addRed(num);
    }

    @Override
    public void addBlue(int num) {
        soraka.addBlue(num);
    }

    @Override
    public void skillW() {
        if (soraka.getRedQuantity() < 50) {
            System.out.println("《警告》索拉卡的【血量】低于50,不能释放W技能!");
            soraka.setCurrentState(soraka.getNoRedState());
            return;
        }
        if (soraka.getBlueQuantity() < 100) {
            System.out.println("《警告》索拉卡的【蓝量】低于100,不能释放W技能!");
            soraka.setCurrentState(soraka.getNoBlueState());
            return;
        }
        soraka.setRedQuantity(soraka.getRedQuantity() - 50);
        soraka.setBlueQuantity(soraka.getBlueQuantity() - 100);
        System.out.println("技能释放成功!当前血量:" + soraka.getRedQuantity() + ",当前蓝量:" + soraka.getBlueQuantity());
    }
}
