package com.tw.step.assignment3.Units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureUnitTest {
    @Test
    void shouldReturnFahrenheitValueOf100DegreeCelsius() {
        TemperatureUnit celsius = TemperatureUnit.CELSIUS;
        assertEquals(212, celsius.toBase(100));
    }

    @Test
    void shouldReturnFahrenheitValueOf50DegreeCelsius() {
        TemperatureUnit celsius = TemperatureUnit.CELSIUS;
        assertEquals(122, celsius.toBase(50));
    }

    @Test
    void shouldReturnTrueForCompatibleMeasurableUnits() {
        TemperatureUnit celsius = TemperatureUnit.CELSIUS;
        TemperatureUnit fahrenheit = TemperatureUnit.FAHRENHEIT;

        assertTrue(celsius.isUnitCompatible(fahrenheit));
    }

    @Test
    void shouldReturnBaseUnitOfVolume() {
        TemperatureUnit celsius = TemperatureUnit.FAHRENHEIT;
        assertEquals(TemperatureUnit.FAHRENHEIT, celsius.baseUnit());
    }
}