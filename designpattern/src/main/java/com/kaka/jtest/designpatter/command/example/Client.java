package com.kaka.jtest.designpatter.command.example;

/**
 * @author: jsk
 * @date: 2019/7/6 16:56
 */
public class Client {
    public static void main(String[] args) {
        // 1.创建接收者
        GalenSkill galenSkill = new GalenSkill();
        SejuaniSkill sejuaniSkill = new SejuaniSkill();

        // 2.创建命令对象
        GalenCommand galenCommand = new GalenCommand(galenSkill);
        SejuaniCommand sejuaniCommand = new SejuaniCommand(sejuaniSkill);

        // 3.创建Invoker
        SylasInvoker sylasInvoker = new SylasInvoker();
        System.out.println("设置R键为盖伦的大招...");
        sylasInvoker.setSkillR(galenCommand);
        sylasInvoker.releaseR();
        System.out.println("-----------------------");
        System.out.println("设置R键为猪妹的大招...");
        sylasInvoker.setSkillR(sejuaniCommand);
        sylasInvoker.releaseR();
    }
}
