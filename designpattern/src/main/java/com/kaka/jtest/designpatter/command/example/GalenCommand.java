package com.kaka.jtest.designpatter.command.example;

/**
 * @author: jsk
 * @date: 2019/7/6 17:44
 */
public class GalenCommand implements Command {
    private GalenSkill galenSkill;

    public GalenCommand(GalenSkill galenSkill) {
        this.galenSkill = galenSkill;
    }

    @Override
    public void execute() {
        System.out.println("命令模式,释放盖伦的大招!");
        galenSkill.justice();
    }

    @Override
    public void undo() {

    }
}
