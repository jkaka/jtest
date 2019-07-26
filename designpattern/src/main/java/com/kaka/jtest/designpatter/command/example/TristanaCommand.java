package com.kaka.jtest.designpatter.command.example;

/**
 * @author: jsk
 * @date: 2019/7/6 17:52
 */
public class TristanaCommand implements Command {
    private TristanaSkill tristanaSkill;

    public TristanaCommand(TristanaSkill tristanaSkill) {
        this.tristanaSkill = tristanaSkill;
    }

    @Override
    public void execute() {
        System.out.println("释放崔丝塔娜(小炮)的大招!");
        tristanaSkill.shoot();
    }

    @Override
    public void undo() {

    }
}
