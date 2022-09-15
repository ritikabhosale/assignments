package com.tw.step.assignment3.Units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureUnitTest {
    @Test
    void toBase() {
        TemperatureUnit fahrenheit = TemperatureUnit.FAHRENHEIT;
        assertEquals(100, fahrenheit.toBase(212));
    }

    @Test
    void shouldReturnTrueForCompatibleMeasurableUnits() {
        TemperatureUnit celsius = TemperatureUnit.CELSIUS;
        TemperatureUnit fahrenheit = TemperatureUnit.FAHRENHEIT;

        assertTrue(celsius.isUnitCompatible(fahrenheit));
    }

    @Test
    void shouldReturnBaseUnitOfVolume() {
        TemperatureUnit celsius = TemperatureUnit.CELSIUS;
        assertEquals(TemperatureUnit.CELSIUS, celsius.baseUnit());
    }
}