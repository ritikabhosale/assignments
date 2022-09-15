package com.tw.step.assignment3.Units;

public enum TemperatureUnit implements Unit {
    CELSIUS(1), FAHRENHEIT(100/212d);

    private final double inBase;

    TemperatureUnit(double inBase) {
        this.inBase = inBase;
    }

    @Override
    public double toBase(double value) {
        return this.inBase * value;
    }

    @Override
    public boolean isUnitCompatible(Unit unit) {
        return unit instanceof TemperatureUnit;
    }

    @Override
    public Unit baseUnit() {
        return TemperatureUnit.CELSIUS;
    }
}
