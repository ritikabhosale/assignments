package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.NegativeLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldThrowNegativeLengthException() {
        assertThrows(NegativeLengthException.class, () -> Length.createLength(-1, LengthUnit.FEET));
    }

    @Test
    void shouldCompareLengthsOfSameUnitHavingSameValues() throws NegativeLengthException {
        Length length1 = Length.createLength(1, LengthUnit.INCH);
        Length length2 = Length.createLength(1, LengthUnit.INCH);

        assertEquals(0, length1.compare(length2));
    }

    @Test
    void shouldCompareLengthInFeetAndInchesIfLengthInFeetIsLesser() throws NegativeLengthException {
        Length lengthInFeet = Length.createLength(1, LengthUnit.FEET);
        Length lengthInInches = Length.createLength(15, LengthUnit.INCH);

        assertEquals(-1, lengthInFeet.compare(lengthInInches));
    }

    @Test
    void shouldCompareLengthInFeetAndInchesIfLengthIsEqual() throws NegativeLengthException {
        Length lengthInFeet = Length.createLength(1, LengthUnit.FEET);
        Length lengthInInches = Length.createLength(12, LengthUnit.INCH);

        assertEquals(0, lengthInFeet.compare(lengthInInches));
    }

    @Test
    void shouldCompareLengthInInchesAndCentimetersIfLengthIsEqual() throws NegativeLengthException {
        Length lengthInInches = Length.createLength(4, LengthUnit.INCH);
        Length lengthInCentimeters = Length.createLength(10, LengthUnit.CM);

        assertEquals(0, lengthInInches.compare(lengthInCentimeters));
    }

    @Test
    void shouldCompareLengthInInchesAndCentimetersIfLengthInInchesIsGreater() throws NegativeLengthException {
        Length lengthInInches = Length.createLength(5, LengthUnit.INCH);
        Length lengthInCentimeters = Length.createLength(10, LengthUnit.CM);

        assertEquals(1, lengthInInches.compare(lengthInCentimeters));
    }

    @Test
    void shouldCompareLengthInCentimetersAndMillimetersIfLengthIsSame() throws NegativeLengthException {
        Length lengthInCentimeters = Length.createLength(1, LengthUnit.CM);
        Length lengthInMillimeters = Length.createLength(10, LengthUnit.MM);

        assertEquals(0, lengthInCentimeters.compare(lengthInMillimeters));
    }

    @Test
    void shouldCompareLengthInInchesAndMillimetersIfLengthIsSame() throws NegativeLengthException {
        Length lengthInInches = Length.createLength(2, LengthUnit.INCH);
        Length lengthInMillimeters = Length.createLength(50, LengthUnit.MM);

        assertEquals(0, lengthInInches.compare(lengthInMillimeters));
    }
}