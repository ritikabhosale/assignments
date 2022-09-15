package com.tw.step.assignment3.Units;

import com.tw.step.assignment3.exception.IncompatibleUnitsException;
import com.tw.step.assignment3.exception.NegativeValueException;

import java.util.Objects;

public class MeasurableUnit {

    private final double value;
    private final Unit unit;

    private MeasurableUnit(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static MeasurableUnit createMeasurableUnit(double value, Unit unit) throws NegativeValueException {
        if (value < 0) {
            throw new NegativeValueException(value);
        }
        return new MeasurableUnit(value, unit);
    }

    private void validateSameUnits(Unit otherUnit) throws IncompatibleUnitsException {
        if (!this.unit.isUnitCompatible(otherUnit)) {
            throw new IncompatibleUnitsException();
        }
    }

    public int compare(MeasurableUnit otherUnit) throws IncompatibleUnitsException {
        validateSameUnits(otherUnit.unit);

        double valueInBaseOfUnit1 = this.unit.toBase(this.value);
        double valueInBaseOfUnit2 = otherUnit.unit.toBase(otherUnit.value);

        if (valueInBaseOfUnit1 > valueInBaseOfUnit2) {
            return 1;
        } else if (valueInBaseOfUnit1 < valueInBaseOfUnit2) {
            return -1;
        }
        return 0;
    }

    public MeasurableUnit add(MeasurableUnit otherUnit) throws IncompatibleUnitsException, NegativeValueException {
        validateSameUnits(otherUnit.unit);

        double valueInBaseOfUnit1 = this.unit.toBase(this.value);
        double valueInBaseOfUnit2 = otherUnit.unit.toBase(otherUnit.value);

        double addedValue = valueInBaseOfUnit1 + valueInBaseOfUnit2;
        Unit unitType = this.unit.baseUnit();

        return createMeasurableUnit(addedValue, unitType);
    }

    public boolean isAlmostEqual(MeasurableUnit expectedVolume, double delta) {
        return Math.abs(this.value - expectedVolume.value) < delta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasurableUnit that = (MeasurableUnit) o;

        if (Double.compare(that.value, value) != 0) return false;
        return Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
