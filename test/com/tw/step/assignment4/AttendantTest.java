package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.ParkingLotNotEmptyException;
import com.tw.step.assignment4.exception.ParkingLotsNotEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
    @Test
    void shouldParkTheVehicle() throws ParkingLotsNotEmptyException, ParkingLotNotEmptyException {
        ParkingLots parkingLots = ParkingLots.create(1, 1, new Notifier());
        Vehicle vehicle = new Vehicle("123");

        Attendant attendant = new Attendant(parkingLots);

        assertTrue(attendant.park(vehicle));
    }

    @Test
    void shouldNotifyOnDesiredCondition() throws ParkingLotsNotEmptyException, ParkingLotNotEmptyException {
        Notifier notifier = new Notifier();
        ParkingLots parkingLots = ParkingLots.create(1, 5, notifier);
        Vehicle vehicle = new Vehicle("123");

        Attendant attendant = new Attendant(parkingLots);
        notifier.register(attendant);

        assertTrue(attendant.park(vehicle));
    }
}
