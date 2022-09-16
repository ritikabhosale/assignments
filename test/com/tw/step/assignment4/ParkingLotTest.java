package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldParkAVehicle() {
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle("123");
        assertEquals(new Slot("1"), parkingLot.park(vehicle));
    }
}