package com.tw.step.assignment5.exception;

public class BagCapacityExceededException extends Throwable {
    private final int maxQuantityOfBalls;

    public BagCapacityExceededException(int maxQuantityOfBalls) {
        this.maxQuantityOfBalls = maxQuantityOfBalls;
    }

    @Override
    public String getMessage() {
        return String.format("Bag cannot hold more than %d balls", this.maxQuantityOfBalls);
    }
}
