package com.kaka.jtest.designpatter.command.example;

/**
 * @author: jsk
 * @date: 2019/7/6 17:52
 */
public class SejuaniCommand implements Command {
    private SejuaniSkill sejuaniSkill;

    public SejuaniCommand(SejuaniSkill sejuaniSkill) {
        this.sejuaniSkill = sejuaniSkill;
    }

    @Override
    public void execute() {
        System.out.println("命令模式,释放瑟庄妮(猪妹)的大招!");
        sejuaniSkill.veryCode();
    }

    @Override
    public void undo() {

    }
}
