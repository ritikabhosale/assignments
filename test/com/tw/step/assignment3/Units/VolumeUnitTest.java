package com.tw.step.assignment3.Units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeUnitTest {
    @Test
    void shouldReturnVolumeInLiter() {
        VolumeUnit gallon = VolumeUnit.GALLON;
        assertEquals(3.78, gallon.toBase(1));
    }

    @Test
    void shouldReturnTrueForCompatibleMeasurableUnits() {
        VolumeUnit gallon = VolumeUnit.GALLON;
        VolumeUnit liter = VolumeUnit.LITER;

        assertTrue(gallon.isUnitCompatible(liter));
    }

    @Test
    void shouldReturnBaseUnitOfVolume() {
        VolumeUnit gallon = VolumeUnit.GALLON;
        assertEquals(VolumeUnit.LITER, gallon.baseUnit());
    }
}