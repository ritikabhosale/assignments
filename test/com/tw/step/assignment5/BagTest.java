package com.tw.step.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddABallInBag() {
        Bag bag = new Bag();
        Ball ball1 = new Ball("b1");

        assertTrue(bag.add(ball1));
    }
}