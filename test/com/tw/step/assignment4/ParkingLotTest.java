package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.LotNotEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldParkAVehicle() throws LotNotEmptyException {
        ParkingLot parkingLot = ParkingLot.createParkingLot(5);
        Vehicle vehicle = new Vehicle("123");

        assertEquals(new Slot("1"), parkingLot.park(vehicle));
    }

    @Test
    void shouldThrowLotNotEmptyExceptionWhenLotIsFull() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(0);
        Vehicle vehicle = new Vehicle("123");

        assertThrows(LotNotEmptyException.class, () -> parkingLot.park(vehicle));
    }
}
