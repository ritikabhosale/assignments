package com.tw.step.assignment5;

import java.util.HashSet;

public class Bag {
    private final int maxQuantityOfBalls;
    private final HashSet<Ball> balls;

    public Bag() {
        this.maxQuantityOfBalls = 12;
        this.balls = new HashSet<Ball>();
    }

    public boolean add(Ball ball) {
        return this.balls.add(ball);
    }
}
