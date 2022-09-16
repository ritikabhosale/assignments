package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.LotNotEmptyException;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingLot {
    private final String lotId;
    private final ArrayList<Slot> slots;

    private ParkingLot(String lotId, ArrayList<Slot> slots) {
        this.lotId = lotId;
        this.slots = slots;
    }

    static ParkingLot create(String lotId, int capacity) {
        ArrayList<Slot> slots = createSlots(lotId, capacity);
        return new ParkingLot(lotId, slots);
    }

    private static ArrayList<Slot> createSlots(String lotId, int capacity) {
        ArrayList<Slot> slots = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            slots.add(new Slot(String.format("%sS%d", lotId, i + 1)));
        }
        return slots;
    }

    public Slot park(Vehicle vehicle) throws LotNotEmptyException {
        Slot slot = getFirstEmptySlot();
        slot.park();
        return slot;
    }

    private Slot getFirstEmptySlot() throws LotNotEmptyException {
        for (Slot slot : this.slots) {
            if (slot.isAvailable()) {
                return slot;
            }
        }
        throw new LotNotEmptyException();
    }

    public double percentageOfSpaceOccupied() {
        double numberOfFilledSlots = this.slots.stream()
                .filter(slot -> !slot.isAvailable())
                .count();

        return (numberOfFilledSlots / slots.size()) * 100;
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
