package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotsTest {
    @Test
    void shouldCreateParkingLots() {
        ParkingLots parkingLots1 = ParkingLots.create(1, 1, new Notifier());
        ParkingLots parkingLots2 = ParkingLots.create(1, 1, new Notifier());

        assertEquals(parkingLots1, parkingLots2);
    }
}
