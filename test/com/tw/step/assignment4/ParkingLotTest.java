package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.LotNotEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldParkAVehicle() throws LotNotEmptyException {
        ParkingLot parkingLot = ParkingLot.create("L1", 5);
        Vehicle vehicle = new Vehicle("123");

        assertEquals(new Slot("L1S1"), parkingLot.park(vehicle));
    }

    @Test
    void shouldThrowLotNotEmptyExceptionWhenLotIsFull() {
        ParkingLot parkingLot = ParkingLot.create("L1", 0);
        Vehicle vehicle = new Vehicle("123");

        assertThrows(LotNotEmptyException.class, () -> parkingLot.park(vehicle));
    }

    @Test
    void shouldReturnPercentageOfSpaceOccupied() throws LotNotEmptyException {
        ParkingLot parkingLot = ParkingLot.create("L1", 1);
        parkingLot.park(new Vehicle("234"));

        assertEquals(100, parkingLot.percentageOfSpaceOccupied());
    }
}
