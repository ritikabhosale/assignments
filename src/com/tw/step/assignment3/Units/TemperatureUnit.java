package com.tw.step.assignment3.Units;

public enum TemperatureUnit implements Unit {
    CELSIUS(9/5d, 32), FAHRENHEIT(1, 0);

    private final double slope;
    private final double constant;

    TemperatureUnit(double slope, double constant) {
        this.slope = slope;
        this.constant = constant;
    }

    @Override
    public double toBase(double value) {
        return this.slope * value + constant;
    }

    @Override
    public boolean isUnitCompatible(Unit unit) {
        return unit instanceof TemperatureUnit;
    }

    @Override
    public Unit baseUnit() {
        return TemperatureUnit.FAHRENHEIT;
    }
}
