package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.NegativeLengthException;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length createLength(double value, LengthUnit unit) throws NegativeLengthException {
        if (value < 0) {
            throw new NegativeLengthException(value);
        }
        return new Length(value, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;

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

    public int compare(Length length) {
        if (this.unit == length.unit) {
            return compareValue(this.value, length.value);
        }

        double valueInCmOfLength1 = this.unit.inCentimeters() * this.value;
        double valueInCmOfLength2 = length.unit.inCentimeters() * length.value;

        return compareValue(valueInCmOfLength1, valueInCmOfLength2);
    }

    private static int compareValue(double value1, double value2) {
        if (value1 > value2) {
            return 1;
        } else if (value1 < value2) {
            return -1;
        }
        return 0;
    }
}
