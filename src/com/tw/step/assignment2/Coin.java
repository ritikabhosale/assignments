package com.tw.step.assignment2;

public class Coin {
    private final int chancesOfGettingTail;
    private final int chancesOfGettingHead;

    private Coin(int chancesOfGettingTail, int chancesOfGettingHead) {
        this.chancesOfGettingTail = chancesOfGettingTail;
        this.chancesOfGettingHead = chancesOfGettingHead;
    }

    public static Coin createFairCoin() {
        return new Coin(50, 50);
    }

    public static Coin createRiggedCoin(int chancesOfGettingTail, int chancesOfGettingHead) {
        return new Coin(chancesOfGettingTail, chancesOfGettingHead);
    }

    public int calculateChanceOfGettingTail() {
        return this.chancesOfGettingTail;
    }

    public int calculateChanceOfGettingHead() {
        return this.chancesOfGettingHead;
    }
}
