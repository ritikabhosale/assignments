package com.tw.step.assignment4;

import java.util.Objects;

public class Slot {
    private final String slotId;
    private boolean isAvailable;

    Slot(String slotId){
        this.slotId = slotId;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slot slot = (Slot) o;

        return Objects.equals(slotId, slot.slotId);
    }

    @Override
    public int hashCode() {
        return slotId != null ? slotId.hashCode() : 0;
    }

    public void park() {
        this.isAvailable = false;
    }
}
