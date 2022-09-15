package com.tw.step.assignment3.Units;

public enum LengthUnit implements Unit {
    FEET(12), INCH(1), MM(0.04), CM(0.4);

    private final double inBase;

    LengthUnit(double inBase) {
        this.inBase = inBase;
    }

    @Override
    public double toBase(double value) {
        return value * this.inBase;
    }

    @Override
    public boolean isUnitCompatible(Unit unit) {
        return unit instanceof LengthUnit;
    }
}
