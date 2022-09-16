package com.tw.step.assignment4;

import java.util.Objects;

public class Slot {
    private final String slotId;

    Slot(String slotId){
        this.slotId = slotId;
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
}
