package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.BallColor;

public class BallCannotBePresentTogetherException extends BallCannotBeAddedException{
    private final BallColor ballColor1;
    private final BallColor ballColor2;

    public BallCannotBePresentTogetherException(BallColor ballColor1, BallColor ballColor2) {
        this.ballColor1 = ballColor1;
        this.ballColor2 = ballColor2;
    }

    @Override
    public String getMessage() {
        return String.format("Cannot add %s ball in presence of %s ball", this.ballColor1, this, ballColor2);
    }
}
