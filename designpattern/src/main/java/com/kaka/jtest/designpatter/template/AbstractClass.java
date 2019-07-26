package com.kaka.jtest.designpatter.template;

/**
 * @author: jsk
 * @date: 2019/7/14 16:45
 */
public abstract class AbstractClass {
    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        if(hook()){
            primitiveOperation3();
        }
    }

    public final void primitiveOperation1() {
        System.out.println("无需子类实现的方法1");
    }

    public abstract void primitiveOperation2();

    public void primitiveOperation3() {
        System.out.println("子类可实现可不实现的方法3");
    }

    /**
     * 钩子方法,子类可以通过这个方法来控制父类的逻辑
     *
     * @return
     */
    public boolean hook() {
        return true;
    }

    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
