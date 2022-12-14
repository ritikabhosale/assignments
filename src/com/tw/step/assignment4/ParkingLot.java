package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.ParkingLotNotEmptyException;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingLot {
    private final String lotId;
    private final ArrayList<Slot> slots;
    private final Notifier notifier;

    private ParkingLot(String lotId, ArrayList<Slot> slots, Notifier notifier) {
        this.lotId = lotId;
        this.slots = slots;
        this.notifier = notifier;
    }

    static ParkingLot create(String lotId, int capacity,  Notifier notifier) {
        ArrayList<Slot> slots = createSlots(lotId, capacity);
        return new ParkingLot(lotId, slots, notifier);
    }

    private static ArrayList<Slot> createSlots(String lotId, int capacity) {
        ArrayList<Slot> slots = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            slots.add(new Slot(String.format("%sS%d", lotId, i + 1)));
        }
        return slots;
    }

    public Slot park(Vehicle vehicle) throws ParkingLotNotEmptyException {
        Slot slot = getFirstEmptySlot();
        slot.park();
        notifier.notifyReceivers(this.lotId, this.percentageOfSpaceOccupied());
        return slot;
    }

    private Slot getFirstEmptySlot() throws ParkingLotNotEmptyException {
        for (Slot slot : this.slots) {
            if (slot.isAvailable()) {
                return slot;
            }
        }
        throw new ParkingLotNotEmptyException();
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
