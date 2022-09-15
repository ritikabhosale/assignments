package com.tw.step.assignment3.Units;

public interface Unit {
    double toBase(double value);

    boolean isUnitCompatible(Unit unit);

    Unit baseUnit();
}
