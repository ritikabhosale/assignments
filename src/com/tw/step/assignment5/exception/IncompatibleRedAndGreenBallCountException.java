package com.tw.step.assignment5.exception;

public class IncompatibleRedAndGreenBallCountException extends Exception{
    private final int countOfGreen;
    private final int countOfRed;

    public IncompatibleRedAndGreenBallCountException(int countOfGreen, int countOfRed) {
        this.countOfGreen = countOfGreen;
        this.countOfRed = countOfRed;
    }

    @Override
    public String getMessage() {
        return String.format("Cannot add more than double the number of red balls as there are green balls, red : %d, green : %d", this.countOfRed, this.countOfGreen);
    }
}
