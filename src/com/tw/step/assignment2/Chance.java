package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;

public class Chance {
    private final double probability;

    private Chance(double probability) {
        this.probability = probability;
    }

    public static Chance createChance(double probability) throws InvalidProbabilityException {
        if (probability >= 0 && probability <= 1) {
            return new Chance(probability);
        }
        throw new InvalidProbabilityException(probability);
    }

    public Chance not() {
        return new Chance(1 - this.probability);
    }

    public Chance combineChance(Chance chance) {
        double probability = this.probability * chance.probability;
        return new Chance(probability);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chance chance = (Chance) o;

        return Double.compare(chance.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(probability);
        return (int) (temp ^ (temp >>> 32));
    }
}
