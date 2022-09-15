package com.tw.step.assignment3.Units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthUnitTest {

    @Test
    void shouldReturnFeetInInches() {
        LengthUnit feet = LengthUnit.FEET;
        assertEquals(24, feet.toBase(2));
    }

    @Test
    void shouldReturnInchesInInches() {
        LengthUnit inch = LengthUnit.INCH;
        assertEquals(3, inch.toBase(3));
    }

    @Test
    void shouldReturnMillimetersInInches() {
        LengthUnit millimeters = LengthUnit.MM;
        assertEquals(2, millimeters.toBase(50));
    }
}