package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.*;

import java.util.HashSet;

public class Bag {
    private final int maxQuantityOfBalls;
    private final HashSet<Ball> balls;

    public Bag() {
        this.maxQuantityOfBalls = 12;
        this.balls = new HashSet<>();
    }

    private boolean isColoredBallPresent(BallColor ballColor) {
        return this.countOf(ballColor) > 0;
    }

    private int countOf(BallColor ballColor) {
        return (int) this.balls.stream()
                .filter(ball -> ball.getColor() == ballColor)
                .count();
    }

    private void validateBlackBall() throws BallCannotBePresentTogetherException {
        if (this.isColoredBallPresent(BallColor.BLUE)) {
            throw new BallCannotBePresentTogetherException(BallColor.BLACK, BallColor.BLUE);
        }
    }

    private void validateBlueBall() throws BallCannotBePresentTogetherException {
        if (this.isColoredBallPresent(BallColor.BLACK)) {
            throw new BallCannotBePresentTogetherException(BallColor.BLUE, BallColor.BLACK);
        }
    }

    private void validateYellowBall() throws BallCountCannotBeMoreThan40PercentException {
        int totalBallsAfterAdding = this.balls.size() + 1;
        int totalYellowBallsAfterAdding = this.countOf(BallColor.YELLOW) + 1;

        double percentageOfYellowBalls = totalYellowBallsAfterAdding * 100.0 / totalBallsAfterAdding;

        if (percentageOfYellowBalls > 40) {
            throw new BallCountCannotBeMoreThan40PercentException(BallColor.YELLOW, percentageOfYellowBalls);
        }
    }

    private void validateRedBall() throws IncompatibleRedAndGreenBallCountException {
        int countOfRed = this.countOf(BallColor.RED);
        int countOfGreen = this.countOf(BallColor.GREEN);

        if (2 * countOfGreen <= countOfRed) {
            throw new IncompatibleRedAndGreenBallCountException(countOfGreen, countOfRed);
        }
    }

    private void validateGreenBall() throws BallLimitExceededException {
        if (this.countOf(BallColor.GREEN) >= 3) {
            throw new BallLimitExceededException(3, BallColor.GREEN);
        }
    }

    private void validateBallToAdd(Ball ball) throws BallCannotBeAddedException {
        switch (ball.getColor()) {
            case GREEN:
                validateGreenBall();
                break;
            case RED:
                validateRedBall();
                break;
            case YELLOW:
                validateYellowBall();
                break;
            case BLACK:
                validateBlackBall();
                break;
            case BLUE:
                validateBlueBall();
                break;
        }
    }

    private boolean isBagFull() {
        return this.balls.size() >= this.maxQuantityOfBalls;
    }

    public boolean add(Ball ball) throws BallCannotBeAddedException {
        if (this.isBagFull()) {
            throw new BagLimitExceededException(this.maxQuantityOfBalls);
        }

        this.validateBallToAdd(ball);

        return this.balls.add(ball);
    }
}
