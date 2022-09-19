package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.ParkingLotNotEmptyException;
import com.tw.step.assignment4.exception.ParkingLotsNotEmptyException;

public class Attendant implements Receiver {
    private final ParkingLots parkingLots;

    public Attendant(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public void receive(String lotId, double spaceOccupied) {
        System.out.println("Promote " + lotId);
    }

    @Override
    public boolean receiveNotificationOn(String lotId, double spaceOccupied) {
        return spaceOccupied <= 20;
    }

    public boolean park(Vehicle vehicle) throws ParkingLotsNotEmptyException, ParkingLotNotEmptyException {
        ParkingLot parkingLot = parkingLots.getSpaciousLot();
        parkingLot.park(vehicle);
        return true;
    }
}
