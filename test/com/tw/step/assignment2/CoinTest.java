package com.tw.step.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {
    @Test
    void calculateChanceOfGettingTail() {
        Coin fairCoin = Coin.createFairCoin();
        assertEquals(50, fairCoin.calculateChanceOfGettingTail());
    }

    @Test
    void calculateChanceOfGettingHead() {
        Coin fairCoin = Coin.createFairCoin();
        assertEquals(50, fairCoin.calculateChanceOfGettingHead());
    }

    void calculateChanceOfGettingTailForRiggedCoin() {
        Coin riggedCoin = Coin.createRiggedCoin(40, 60);
        assertEquals(40, riggedCoin.calculateChanceOfGettingHead());
    }
}