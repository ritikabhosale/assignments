package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.Color;

public class BallLimitExceededException extends BallCannotBeAddedException {
    private final int limit;
    private final Color color;

    public BallLimitExceededException(int limit, Color color) {
        this.limit = limit;
        this.color = color;
    }

    @Override
    public java.lang.String getMessage() {
        return java.lang.String.format("Cannot add more than %d %s balls", this.limit, this.color.name());
    }
}
