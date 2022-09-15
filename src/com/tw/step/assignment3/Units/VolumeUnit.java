package com.tw.step.assignment3.Units;

public enum VolumeUnit implements Unit {
    LITER(1), GALLON(3.78);

    private final double inBase;

    VolumeUnit(double inBase) {
        this.inBase = inBase;
    }

    @Override
    public double toBase(double value) {
        return this.inBase * value;
    }

    @Override
    public boolean isUnitCompatible(Unit unit) {
        return unit instanceof VolumeUnit;
    }

    @Override
    public Unit baseUnit() {
        return VolumeUnit.LITER;
    }
}
