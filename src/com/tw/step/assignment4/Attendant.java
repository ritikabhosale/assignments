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
        if (spaceOccupied < 20) {
            System.out.println("Promote " + lotId);
        }
    }

    public Slot park(Vehicle vehicle) throws ParkingLotsNotEmptyException, ParkingLotNotEmptyException {
        ParkingLot parkingLot = parkingLots.getSpaciousLot();
        return parkingLot.park(vehicle);
    }
}
