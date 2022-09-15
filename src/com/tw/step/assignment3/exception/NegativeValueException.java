package com.tw.step.assignment3.exception;

public class NegativeValueException extends Throwable {
    private final double length;

    public NegativeValueException(double value) {
        this.length = value;
    }

    @Override
    public String getMessage() {
        return String.format("Length cannot be negative : %d", this.length);
    }
}
