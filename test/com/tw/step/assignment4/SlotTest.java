package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlotTest {

    @Test
    void shouldCheckTheAvailabilityOfSlot() {
        Slot slot = new Slot("2");

        assertTrue(slot.isAvailable());
    }

    @Test
    void shouldParkTheVehicle() {
        Slot slot = new Slot("2");
        slot.park();

        assertFalse(slot.isAvailable());
    }
}
