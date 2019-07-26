package com.kaka.jtest.designpatter.template.exmaple;

/**
 * 英雄技能
 *
 * @author: jsk
 * @date: 2019/7/14 16:54
 */
public abstract class AbstractHeroSkill {
    public final void harmSkill() {
        skillQ();
        if (hook()) {
            skillW();
        }
        skillE();
        skillR();
    }

    public abstract void skillQ();

    public abstract void skillW();

    public abstract void skillE();

    public abstract void skillR();

    /**
     * 钩子函数:子类可覆盖这个方法,来控制模板方法中的逻辑
     *
     * @return
     */
    public boolean hook() {
        return true;
    }
}
