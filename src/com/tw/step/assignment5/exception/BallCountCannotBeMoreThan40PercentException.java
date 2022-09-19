package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.BallColor;

public class BallCountCannotBeMoreThan40PercentException extends BallCannotBeAddedException {
    private final BallColor ballColor;
    private final double percentageOfYellowBalls;

    public BallCountCannotBeMoreThan40PercentException(BallColor ballColor, double percentageOfYellowBalls) {
        this.ballColor = ballColor;
        this.percentageOfYellowBalls = percentageOfYellowBalls;
    }

    @Override
    public String getMessage() {
        return String.format("Cannot allow more than 40% of the balls contained to be %s, %s : %f",this.ballColor, this.ballColor, this.percentageOfYellowBalls);
    }
}
