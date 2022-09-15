package com.tw.step.assignment3.Units;

import com.tw.step.assignment3.exception.IncompatibleUnitsException;
import com.tw.step.assignment3.exception.NegativeValueException;

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

        double valueInCmOfLength1 = this.unit.toBase(this.value);
        double valueInCmOfLength2 = otherUnit.unit.toBase(otherUnit.value);

        if (valueInCmOfLength1 > valueInCmOfLength2) {
            return 1;
        } else if (valueInCmOfLength1 < valueInCmOfLength2) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasurableUnit length = (MeasurableUnit) o;

        if (Double.compare(length.value, value) != 0) return false;
        return unit == length.unit;
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
