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
}