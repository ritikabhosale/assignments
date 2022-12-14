package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.ParkingLotsNotEmptyException;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingLots {
    private final ArrayList<ParkingLot> parkingLots;
    private final Notifier notifier;

    private ParkingLots(ArrayList<ParkingLot> parkingLots, Notifier notifier) {
        this.parkingLots = parkingLots;
        this.notifier = notifier;
    }

    public static ParkingLots create(int numberOfLots, int capacityOfEachLot, Notifier notifier) {
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        for (int i = 0; i < numberOfLots; i++) {
            parkingLots.add(ParkingLot.create(String.format("L%d", i + 1), capacityOfEachLot, notifier));
        }
        return new ParkingLots(parkingLots, notifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingLots that = (ParkingLots) o;

        return Objects.equals(parkingLots, that.parkingLots);
    }

    @Override
    public int hashCode() {
        return parkingLots != null ? parkingLots.hashCode() : 0;
    }

    public ParkingLot getSpaciousLot() throws ParkingLotsNotEmptyException {
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.percentageOfSpaceOccupied() < 100) {
                return parkingLot;
            }
        }
        throw new ParkingLotsNotEmptyException();
    }
}
