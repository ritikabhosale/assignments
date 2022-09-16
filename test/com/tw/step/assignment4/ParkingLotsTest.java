package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotsTest {
    @Test
    void shouldCreateParkingLots() {
        ParkingLots parkingLots1 = ParkingLots.create(1, 1);
        ParkingLots parkingLots2 = ParkingLots.create(1, 1);

        assertEquals(parkingLots1, parkingLots2);
    }
}
