package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.Color;

public class BallCannotBePresentTogetherException extends BallCannotBeAddedException{
    private final Color color1;
    private final Color color2;

    public BallCannotBePresentTogetherException(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    @Override
    public String getMessage() {
        return String.format("Cannot add %s ball in presence of %s ball", this.color1, this, color2);
    }
}
