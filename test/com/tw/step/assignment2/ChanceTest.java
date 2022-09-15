package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void shouldCreateANewChance() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.75);
        assertEquals(chance, chance);
    }

    @Test
    void shouldCreateNotOfAChance() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.75);
        Chance notOfChance = chance.not();

        assertEquals(notOfChance, Chance.createChance(0.25));
    }

    @Test
    void shouldThrowOnCreatingInvalidChance() {
        assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(1.2));
    }

    @Test
    void shouldReturnChanceOfGettingTails() throws InvalidProbabilityException {
        Chance chanceOfGettingOneOnDice = Chance.createChance(1/6d);
        Chance chanceOfGettingATail = Chance.createChance(0.5);

        Chance chance = chanceOfGettingOneOnDice.and(chanceOfGettingATail);
        assertEquals(chance, Chance.createChance(1/12d));
    }

    @Test
    void shouldReturnFalseOnWrongComplimentOfChance() throws InvalidProbabilityException {
        Chance chanceOfGettingOneOnDice = Chance.createChance(1/6d);
        Chance chanceOfNotGettingOneOnADice = chanceOfGettingOneOnDice.not();

        assertNotEquals(chanceOfNotGettingOneOnADice, Chance.createChance(0.35));
    }

    @Test
    void shouldReturnChanceOfAtLeastOneTail() throws InvalidProbabilityException {
        Chance chanceOfGettingTailOnACoin = Chance.createChance(0.5);

        assertEquals(chanceOfGettingTailOnACoin.or(chanceOfGettingTailOnACoin), Chance.createChance(0.75));
    }
}