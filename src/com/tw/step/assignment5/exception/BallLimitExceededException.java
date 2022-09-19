package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.BallColor;

public class BallLimitExceededException extends BallCannotBeAddedException {
    private final int limit;
    private final BallColor ballColor;

    public BallLimitExceededException(int limit, BallColor ballColor) {
        this.limit = limit;
        this.ballColor = ballColor;
    }

    @Override
    public String getMessage() {
        return String.format("Cannot add more than %d %s balls", this.limit, this.ballColor);
    }
}
