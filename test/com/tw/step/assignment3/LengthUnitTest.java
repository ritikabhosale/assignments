package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthUnitTest {

    @Test
    void shouldReturnFeetInCentimeters() {
        LengthUnit feet = LengthUnit.FEET;
        assertEquals(60, feet.inCentimeters(2));
    }

    @Test
    void shouldReturnInchesInCentimeters() {
        LengthUnit inch = LengthUnit.INCH;
        assertEquals(7.5, inch.inCentimeters(3));
    }

    @Test
    void shouldReturnMillimetersInCentimeters() {
        LengthUnit millimeters = LengthUnit.MM;
        assertEquals(2, millimeters.inCentimeters(20));
    }
}