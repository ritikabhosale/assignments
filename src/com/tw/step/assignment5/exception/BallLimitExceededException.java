package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.Color;

public class BallLimitExceededException extends Exception{
    private final int limit;
    private final Color color;

    public BallLimitExceededException(int limit, Color color) {
        this.limit = limit;
        this.color = color;
    }

    @Override
    public String getMessage() {
        return String.format("Cannot add more than %d %s balls", this.limit, this.color.name());
    }
}
