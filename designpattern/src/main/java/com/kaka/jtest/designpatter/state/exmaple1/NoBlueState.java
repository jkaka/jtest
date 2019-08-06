package com.kaka.jtest.designpatter.state.exmaple1;

/**
 * @author: jsk
 * @date: 2019/7/27 14:44
 */
public class NoBlueState implements SorakaState {
    private Soraka soraka;

    public NoBlueState(Soraka soraka) {
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
        System.out.println("蓝量不够无法释放W技能,请给索拉卡加蓝！");
    }
}
