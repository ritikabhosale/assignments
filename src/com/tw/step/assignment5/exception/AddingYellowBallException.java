package com.tw.step.assignment5.exception;

public class AddingYellowBallException extends BallCannotBeAddedException {
    private final double percentageOfYellowBalls;

    public AddingYellowBallException(double percentageOfYellowBalls) {
        this.percentageOfYellowBalls = percentageOfYellowBalls;
    }

    @Override
    public String getMessage() {
        return String.format("Cannot allow more than 40% of the balls contained to be yellow, yellow : %f", this.percentageOfYellowBalls);
    }
}
