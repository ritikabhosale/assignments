package com.tw.step.assignment5.exception;

public class BagLimitExceededException extends BallCannotBeAddedException {
    private final int maxQuantityOfBalls;

    public BagLimitExceededException(int maxQuantityOfBalls) {
        this.maxQuantityOfBalls = maxQuantityOfBalls;
    }

    @Override
    public String getMessage() {
        return String.format("Bag cannot hold more than %d balls", this.maxQuantityOfBalls);
    }
}
