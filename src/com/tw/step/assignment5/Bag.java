package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.AddingYellowBallException;
import com.tw.step.assignment5.exception.BagCapacityExceededException;
import com.tw.step.assignment5.exception.BallLimitExceededException;
import com.tw.step.assignment5.exception.IncompatibleRedAndGreenBallCountException;

import java.util.HashSet;

public class Bag {
    private final int maxQuantityOfBalls;
    private final HashSet<Ball> balls;

    public Bag() {
        this.maxQuantityOfBalls = 12;
        this.balls = new HashSet<Ball>();
    }

    public boolean add(Ball ball) throws BallLimitExceededException, BagCapacityExceededException, IncompatibleRedAndGreenBallCountException, AddingYellowBallException {
        if (this.balls.size() >= this.maxQuantityOfBalls) {
            throw new BagCapacityExceededException(this.maxQuantityOfBalls);
        }

        this.validateBallToAdd(ball);

        return this.balls.add(ball);
    }

    private void validateBallToAdd(Ball ball) throws BallLimitExceededException, IncompatibleRedAndGreenBallCountException, AddingYellowBallException {
        if (ball.getColor() == Color.GREEN && this.countOf(Color.GREEN) >= 3) {
            throw new BallLimitExceededException(3, Color.GREEN);
        }

        if (ball.getColor() == Color.RED) {
            int countOfRed = this.countOf(Color.RED);
            int countOfGreen = this.countOf(Color.GREEN);
            if (countOfRed >= (2 * countOfGreen)) {
                throw new IncompatibleRedAndGreenBallCountException(countOfGreen, countOfRed);
            }
        }

        if (ball.getColor() == Color.YELLOW) {
            int countOfTotalBallsAfterAddingAYellowBall = this.balls.size() + 1;
            int countOfYellowAfterAddingAYellowBall = this.countOf(Color.YELLOW) + 1;
            if (countOfYellowAfterAddingAYellowBall * 100.0 / countOfTotalBallsAfterAddingAYellowBall > 40) {
                throw new AddingYellowBallException();
            }
        }
    }

    private int countOf(Color color) {
        return (int) this.balls.stream()
                .filter(ball -> ball.getColor() == color)
                .count();
    }
}
