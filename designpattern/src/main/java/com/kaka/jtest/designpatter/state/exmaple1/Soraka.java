package com.kaka.jtest.designpatter.state.exmaple1;

/**
 * @author: jsk
 * @date: 2019/7/27 14:45
 */
public class Soraka {
    private int redQuantity;
    private int blueQuantity;
    private SorakaState healthState;
    private SorakaState noRedState;
    private SorakaState noBlueState;
    private SorakaState currentState;

    public Soraka(int redQuantity, int blueQuantity) {
        this.redQuantity = redQuantity;
        this.blueQuantity = blueQuantity;
        this.healthState = new HealthState(this);
        this.noRedState = new NoRedState(this);
        this.noBlueState = new NoBlueState(this);
        this.currentState = healthState;
        System.out.println("创建一个索拉卡!当前血量:" + redQuantity + ";当前蓝量:" + blueQuantity);
        System.out.println("===========================================");
    }

    public void addRed(int num) {
        redQuantity += num;
        if(redQuantity >= 50){
            currentState = healthState;
        }
        System.out.println("【加血】成功,当前红量:" + redQuantity);
    }

    public void addBlue(int num) {
        blueQuantity += num;
        if(blueQuantity >= 100){
            currentState = healthState;
        }
        System.out.println("【加蓝】成功,当前蓝量:" + redQuantity);
    }

    public void skillW(){
        currentState.skillW();
    }
    public int getRedQuantity() {
        return redQuantity;
    }

    public void setRedQuantity(int redQuantity) {
        this.redQuantity = redQuantity;
    }

    public int getBlueQuantity() {
        return blueQuantity;
    }

    public void setBlueQuantity(int blueQuantity) {
        this.blueQuantity = blueQuantity;
    }

    public SorakaState getNoRedState() {
        return noRedState;
    }

    public SorakaState getNoBlueState() {
        return noBlueState;
    }
    public void setCurrentState(SorakaState currentState) {
        this.currentState = currentState;
    }
}
