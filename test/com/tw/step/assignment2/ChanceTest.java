package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void not() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.75);
        Chance notOfChance = chance.not();
        assertTrue(notOfChance.equals(Chance.createChance(0.25)));
    }

    @Test
    void notShouldReturnFalse() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.75);
        Chance notOfChance = chance.not();
        assertFalse(notOfChance.equals(Chance.createChance(0.35)));
    }

    @Test
    void createChance() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.75);
        assertTrue(chance.equals(chance));
    }

    @Test
    void createChanceShouldThrowException() {
        try {
            Chance chance = Chance.createChance(1.2);
        } catch (InvalidProbabilityException e) {
            String expected = "Probability should be between 0-1, invalid 1.2";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void combineChanceOfGettingAllTails() throws InvalidProbabilityException {
        Chance chance1 = Chance.createChance(0.5);
        Chance chance2 = Chance.createChance(0.5);

        Chance chance = chance1.combineChance(chance2);
        assertTrue(chance.equals(Chance.createChance(0.25)));
    }
}