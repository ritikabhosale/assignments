package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.ParkingLotNotEmptyException;
import com.tw.step.assignment4.exception.ParkingLotsNotEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
    @Test
    void shouldParkTheVehicle() throws ParkingLotsNotEmptyException, ParkingLotNotEmptyException {
        ParkingLots parkingLots = ParkingLots.create(1, 1);
        Vehicle vehicle = new Vehicle("123");
        Attendant attendant = new Attendant(parkingLots);
        Slot slot = new Slot("L1S1");

        assertEquals(slot, attendant.park(vehicle));
    }
}
