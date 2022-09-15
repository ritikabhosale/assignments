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
    void shouldCompareLengthInFeetAndInches() throws NegativeLengthException {
        Length lengthInInches = Length.createLength(1, LengthUnit.INCH);
        Length lengthInFeet = Length.createLength(2, LengthUnit.FEET);

        assertEquals(-1, lengthInInches.compare(lengthInFeet));
    }

    @Test
    void shouldCompareLengthInFeetAndInchesIfLengthIsEqual() throws NegativeLengthException {
        Length lengthInInches = Length.createLength(12, LengthUnit.INCH);
        Length lengthInFeet = Length.createLength(1, LengthUnit.FEET);

        assertEquals(0, lengthInInches.compare(lengthInFeet));
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
        Length lengthInMillimeters = Length.createLength(10, LengthUnit.MM);
        Length lengthInCentimeters = Length.createLength(1, LengthUnit.CM);

        assertEquals(0, lengthInMillimeters.compare(lengthInCentimeters));
    }
}