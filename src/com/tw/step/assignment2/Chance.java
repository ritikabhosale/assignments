package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;

public class Chance {
    public static final int IMPOSSIBILITY = 0;
    public static final int CERTAINTY = 1;
    private final double probability;

    private Chance(double probability) {
        this.probability = probability;
    }

    public static Chance createChance(double probability) throws InvalidProbabilityException {
        if (probability >= IMPOSSIBILITY && probability <= CERTAINTY) {
            return new Chance(probability);
        }
        throw new InvalidProbabilityException(probability);
    }

    public Chance not() {
        return new Chance(1 - this.probability);
    }

    public Chance and(Chance otherChance) {
        double probability = this.probability * otherChance.probability;
        return new Chance(probability);
    }

    public Chance or(Chance otherChance) {
        return this.not().and(otherChance.not()).not();
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
