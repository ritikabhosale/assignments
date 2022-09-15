package com.tw.step.assignment3.exception;

public class NegativeLengthException extends Throwable {
    private final double length;

    public NegativeLengthException(double value) {
        this.length = value;
    }

    @Override
    public String getMessage() {
        return String.format("Length cannot be negative : %d", this.length);
    }
}
