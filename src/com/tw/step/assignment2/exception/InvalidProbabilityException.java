package com.tw.step.assignment2.exception;

public class InvalidProbabilityException extends Throwable {

    private final double probability;

    public InvalidProbabilityException(double probability) {
        this.probability = probability;
    }

    @Override
    public String getMessage() {
        return "Probability should be between 0-1, invalid "+this.probability;
    }
}
