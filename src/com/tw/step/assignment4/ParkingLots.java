package com.tw.step.assignment4;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingLots {
    private final ArrayList<ParkingLot> parkingLots;

    private ParkingLots(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public static ParkingLots create(int numberOfLots, int capacityOfEachLot) {
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        for (int i = 0; i < numberOfLots; i++) {
            parkingLots.add(ParkingLot.create(String.format("L%d", i + 1), capacityOfEachLot));
        }
        return new ParkingLots(parkingLots);
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
}
