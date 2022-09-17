package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.ParkingLotNotEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldParkAVehicle() throws ParkingLotNotEmptyException {
        ParkingLot parkingLot = ParkingLot.create("L1", 5, new Notifier());
        Vehicle vehicle = new Vehicle("123");

        assertEquals(new Slot("L1S1"), parkingLot.park(vehicle));
    }

    @Test
    void shouldThrowLotNotEmptyExceptionWhenLotIsFull() {
        ParkingLot parkingLot = ParkingLot.create("L1", 0, new Notifier());
        Vehicle vehicle = new Vehicle("123");

        assertThrows(ParkingLotNotEmptyException.class, () -> parkingLot.park(vehicle));
    }

    @Test
    void shouldReturnPercentageOfSpaceOccupied() throws ParkingLotNotEmptyException {
        ParkingLot parkingLot = ParkingLot.create("L1", 1, new Notifier());
        parkingLot.park(new Vehicle("234"));

        assertEquals(100, parkingLot.percentageOfSpaceOccupied());
    }
}
