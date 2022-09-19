package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.BagCapacityExceededException;
import com.tw.step.assignment5.exception.BagLimitExceededException;

import java.util.HashSet;

public class Bag {
    private final int maxQuantityOfBalls;
    private final HashSet<Ball> balls;

    public Bag() {
        this.maxQuantityOfBalls = 12;
        this.balls = new HashSet<Ball>();
    }

    private boolean hasLimitExceeded(Ball ball) {
        return ball.getColor() == Color.GREEN && this.countOf(Color.GREEN) >= 3;
    }

    public boolean add(Ball ball) throws BagLimitExceededException, BagCapacityExceededException {
        if (this.balls.size() >= this.maxQuantityOfBalls) {
            throw new BagCapacityExceededException(this.maxQuantityOfBalls);
        }

        if (hasLimitExceeded(ball)) {
            throw new BagLimitExceededException(3, Color.GREEN);
        }

        return this.balls.add(ball);
    }

    private int countOf(Color color) {
        return (int) this.balls.stream()
                .filter(ball -> ball.getColor() == color)
                .count();
    }
}
