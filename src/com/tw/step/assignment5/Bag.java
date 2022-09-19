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

    private boolean isColorPresent(Color color) {
        return this.countOf(color) > 0;
    }

    private int countOf(Color color) {
        return (int) this.balls.stream()
                .filter(ball -> ball.getColor() == color)
                .count();
    }

    private void validateBlackBall() throws BallCannotBePresentTogetherException {
        if (this.isColorPresent(Color.BLUE)) {
            throw new BallCannotBePresentTogetherException(Color.BLACK, Color.BLUE);
        }
    }

    private void validateBlueBall() throws BallCannotBePresentTogetherException {
        if (this.isColorPresent(Color.BLACK)) {
            throw new BallCannotBePresentTogetherException(Color.BLUE, Color.BLACK);
        }
    }

    private void validateYellowBall() throws AddingYellowBallException {
        int totalBallsAfterAdding = this.balls.size() + 1;
        int totalYellowBallsAfterAdding = this.countOf(Color.YELLOW) + 1;

        double percentageOfYellowBalls = totalYellowBallsAfterAdding * 100.0 / totalBallsAfterAdding;

        if (percentageOfYellowBalls > 40) {
            throw new AddingYellowBallException(percentageOfYellowBalls);
        }
    }

    private void validateRedBall() throws IncompatibleRedAndGreenBallCountException {
        int countOfRed = this.countOf(Color.RED);
        int countOfGreen = this.countOf(Color.GREEN);

        if (2 * countOfGreen <= countOfRed) {
            throw new IncompatibleRedAndGreenBallCountException(countOfGreen, countOfRed);
        }
    }

    private void validateGreenBall() throws BallLimitExceededException {
        if (this.countOf(Color.GREEN) >= 3) {
            throw new BallLimitExceededException(3, Color.GREEN);
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

    public boolean add(Ball ball) throws BallCannotBeAddedException {
        if (this.balls.size() >= this.maxQuantityOfBalls) {
            throw new BagLimitExceededException(this.maxQuantityOfBalls);
        }

        this.validateBallToAdd(ball);

        return this.balls.add(ball);
    }
}
