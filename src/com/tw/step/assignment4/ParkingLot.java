package com.tw.step.assignment4;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingLot {
    private final ArrayList<Slot> slots;

    ParkingLot() {
        this.slots = new ArrayList<Slot>();
    }

    public Slot park(Vehicle vehicle) {
        return new Slot("1");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingLot that = (ParkingLot) o;

        return Objects.equals(slots, that.slots);
    }

    @Override
    public int hashCode() {
        return slots != null ? slots.hashCode() : 0;
    }
}
