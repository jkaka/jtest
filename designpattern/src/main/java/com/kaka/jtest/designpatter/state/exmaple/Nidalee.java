package com.kaka.jtest.designpatter.state.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/28 12:06
 */
public class Nidalee {
    private NidaleeState nidaleeLionState;
    private NidaleeState nidaleePersonState;
    private NidaleeState currentState;

    public Nidalee() {
        nidaleeLionState = new NidaleeLionState();
        nidaleePersonState = new NidaleePersonState();
        currentState = nidaleePersonState;
    }

    public void skillQ() {
        currentState.skillQ();
    }

    public void skillW() {
        currentState.skillW();
    }

    public void skillR() {
        if (currentState == nidaleeLionState) {
            System.out.println("\n【切换为人类形态】");
            currentState = nidaleePersonState;
        } else {
            System.out.println("\n【切换为美洲狮形态】");
            currentState = nidaleeLionState;
        }
    }
}
