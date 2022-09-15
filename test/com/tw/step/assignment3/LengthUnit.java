package com.tw.step.assignment3;

public enum LengthUnit {
    FEET(30), INCH(2.5), MM(0.1);

    private final double inInches;

    LengthUnit(double inInch) {
        this.inInches = inInch;
    }

    public double inCentimeters(double value) {
       return value * this.inInches;
    }
}
