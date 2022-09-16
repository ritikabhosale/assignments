package com.tw.step.assignment3.Units;

import com.tw.step.assignment3.exception.IncompatibleUnitsException;
import com.tw.step.assignment3.exception.NegativeValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurableUnitTest {
    @Test
    void shouldThrowNegativeLengthException() {
        assertThrows(NegativeValueException.class, () -> MeasurableUnit.createMeasurableUnit(-1, LengthUnit.FEET));
    }

    @Test
    void shouldCompareLengthsOfSameUnitHavingSameValues() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit length1 = MeasurableUnit.createMeasurableUnit(1, LengthUnit.INCH);
        MeasurableUnit length2 = MeasurableUnit.createMeasurableUnit(1, LengthUnit.INCH);

        assertEquals(0, length1.compare(length2));
    }

    @Test
    void shouldCompareLengthInFeetAndInchesIfLengthInFeetIsLesser() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit lengthInFeet = MeasurableUnit.createMeasurableUnit(1, LengthUnit.FEET);
        MeasurableUnit lengthInInches = MeasurableUnit.createMeasurableUnit(15, LengthUnit.INCH);

        assertEquals(-1, lengthInFeet.compare(lengthInInches));
    }

    @Test
    void shouldCompareLengthInFeetAndInchesIfLengthIsEqual() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit lengthInFeet = MeasurableUnit.createMeasurableUnit(1, LengthUnit.FEET);
        MeasurableUnit lengthInInches = MeasurableUnit.createMeasurableUnit(12, LengthUnit.INCH);

        assertEquals(0, lengthInFeet.compare(lengthInInches));
    }

    @Test
    void shouldCompareLengthInInchesAndCentimetersIfLengthIsEqual() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit lengthInInches = MeasurableUnit.createMeasurableUnit(4, LengthUnit.INCH);
        MeasurableUnit lengthInCentimeters = MeasurableUnit.createMeasurableUnit(10, LengthUnit.CM);

        assertEquals(0, lengthInInches.compare(lengthInCentimeters));
    }

    @Test
    void shouldCompareLengthInInchesAndCentimetersIfLengthInInchesIsGreater() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit lengthInInches = MeasurableUnit.createMeasurableUnit(5, LengthUnit.INCH);
        MeasurableUnit lengthInCentimeters = MeasurableUnit.createMeasurableUnit(10, LengthUnit.CM);

        assertEquals(1, lengthInInches.compare(lengthInCentimeters));
    }

    @Test
    void shouldCompareLengthInCentimetersAndMillimetersIfLengthIsSame() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit lengthInCentimeters = MeasurableUnit.createMeasurableUnit(1, LengthUnit.CM);
        MeasurableUnit lengthInMillimeters = MeasurableUnit.createMeasurableUnit(10, LengthUnit.MM);

        assertEquals(0, lengthInCentimeters.compare(lengthInMillimeters));
    }

    @Test
    void shouldCompareLengthInInchesAndMillimetersIfLengthIsSame() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit lengthInInches = MeasurableUnit.createMeasurableUnit(2, LengthUnit.INCH);
        MeasurableUnit lengthInMillimeters = MeasurableUnit.createMeasurableUnit(50, LengthUnit.MM);

        assertEquals(0, lengthInInches.compare(lengthInMillimeters));
    }

    @Test
    void shouldCompareVolumeInGallonAndLitersWhenBothAreEqual() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit volumeInLiter = MeasurableUnit.createMeasurableUnit(3.78, VolumeUnit.LITER);
        MeasurableUnit volumeInGallon = MeasurableUnit.createMeasurableUnit(1, VolumeUnit.GALLON);

        assertEquals(0, volumeInLiter.compare(volumeInGallon));
    }

    @Test
    void shouldCompareVolumeInGallonAndLitersWhenVolumeInGallonIsGreater() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit volumeInLiter = MeasurableUnit.createMeasurableUnit(3.78, VolumeUnit.LITER);
        MeasurableUnit volumeInGallon = MeasurableUnit.createMeasurableUnit(2, VolumeUnit.GALLON);

        assertEquals(-1, volumeInLiter.compare(volumeInGallon));
    }

    @Test
    void shouldThrowExceptionForIncompatibleUnits() throws NegativeValueException {
        MeasurableUnit volumeInLiter = MeasurableUnit.createMeasurableUnit(3.78, VolumeUnit.LITER);
        MeasurableUnit lengthInInches = MeasurableUnit.createMeasurableUnit(2, LengthUnit.INCH);

        assertThrows(IncompatibleUnitsException.class,()-> volumeInLiter.compare(lengthInInches));
    }

    @Test
    void shouldAddTwoSameUnitLengthsInInches() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit length1 = MeasurableUnit.createMeasurableUnit(1, LengthUnit.INCH);
        MeasurableUnit length2 = MeasurableUnit.createMeasurableUnit(1, LengthUnit.INCH);

        assertEquals(MeasurableUnit.createMeasurableUnit(2, LengthUnit.INCH),length1.add(length2));

    }
    @Test
    void shouldAddTwoDifferentUnitLengthsInInches() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit length1 = MeasurableUnit.createMeasurableUnit(2, LengthUnit.INCH);
        MeasurableUnit length2 = MeasurableUnit.createMeasurableUnit(2.5, LengthUnit.CM);

        assertEquals(MeasurableUnit.createMeasurableUnit(3, LengthUnit.INCH),length1.add(length2));
    }

    @Test
    void shouldAddTwoDifferentUnitVolumeInLiter() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit volumeInLiter = MeasurableUnit.createMeasurableUnit(1, VolumeUnit.LITER);
        MeasurableUnit volumeInGallon = MeasurableUnit.createMeasurableUnit(1, VolumeUnit.GALLON);

        MeasurableUnit addedVolume = volumeInLiter.add(volumeInGallon);
        MeasurableUnit expectedVolume = MeasurableUnit.createMeasurableUnit(4.78, VolumeUnit.LITER);

        assertTrue(addedVolume.isAlmostEqual(expectedVolume, 0.01));
    }

    @Test
    void shouldThrowExceptionForIncompatibleUnitsWhileAdding() throws NegativeValueException {
        MeasurableUnit volumeInLiter = MeasurableUnit.createMeasurableUnit(3.78, VolumeUnit.LITER);
        MeasurableUnit lengthInInches = MeasurableUnit.createMeasurableUnit(2, LengthUnit.INCH);

        assertThrows(IncompatibleUnitsException.class,()-> volumeInLiter.compare(lengthInInches));
    }

    @Test
    void shouldCompareTemperatureInCelsiusAndFahrenheitIfTemperatureInCelsiusIsGreater() throws NegativeValueException, IncompatibleUnitsException {
        MeasurableUnit tempInCelsius = MeasurableUnit.createMeasurableUnit(110, TemperatureUnit.CELSIUS);
        MeasurableUnit tempInFahrenheit = MeasurableUnit.createMeasurableUnit(212, TemperatureUnit.FAHRENHEIT);

        assertEquals(1, tempInCelsius.compare(tempInFahrenheit));
    }
}