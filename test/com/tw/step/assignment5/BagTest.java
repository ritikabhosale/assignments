package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddABallInBag() throws BallCannotBeAddedException {
        Bag bag = new Bag();
        Ball ball1 = new Ball("b1", Color.GREEN);

        assertTrue(bag.add(ball1));
    }

    @Test
    void shouldNotAddMoreThanThreeGreenBalls() throws BallCannotBeAddedException {
        Bag bag = new Bag();
        Ball greenBall1 = new Ball("b1", Color.GREEN);
        Ball greenBall2 = new Ball("b2", Color.GREEN);
        Ball greenBall3 = new Ball("b3", Color.GREEN);
        Ball greenBall4 = new Ball("b4", Color.GREEN);

        bag.add(greenBall1);
        bag.add(greenBall2);
        bag.add(greenBall3);

        assertThrows(BallLimitExceededException.class, () -> bag.add(greenBall4));
    }

    @Test
    void shouldThrowExceptionOnAdding13thBall() throws BallCannotBeAddedException {
        Bag bag = new Bag();
        Ball blueBall1 = new Ball("b1", Color.BLUE);
        Ball blueBall2 = new Ball("b2", Color.BLUE);
        Ball blueBall3 = new Ball("b3", Color.BLUE);
        Ball blueBall4 = new Ball("b4", Color.BLUE);
        Ball blueBall5 = new Ball("b5", Color.BLUE);
        Ball blueBall6 = new Ball("b6", Color.BLUE);
        Ball blueBall7 = new Ball("b7", Color.BLUE);
        Ball blueBall8 = new Ball("b8", Color.BLUE);
        Ball blueBall9 = new Ball("b9", Color.BLUE);
        Ball blueBall10 = new Ball("b10", Color.BLUE);
        Ball blueBall11 = new Ball("b11", Color.BLUE);
        Ball blueBall12 = new Ball("b12", Color.BLUE);
        Ball blueBall13 = new Ball("b13", Color.BLUE);

        bag.add(blueBall1);
        bag.add(blueBall2);
        bag.add(blueBall3);
        bag.add(blueBall4);
        bag.add(blueBall5);
        bag.add(blueBall6);
        bag.add(blueBall7);
        bag.add(blueBall8);
        bag.add(blueBall9);
        bag.add(blueBall10);
        bag.add(blueBall11);
        bag.add(blueBall12);

        assertThrows(BagCapacityExceededException.class, () -> bag.add(blueBall13));
    }

    @Test
    void shouldNotAddRedBallWhenGreenBallIsAbsent() {
        Bag bag = new Bag();
        Ball redBall1 = new Ball("b1", Color.RED);

        assertThrows(IncompatibleRedAndGreenBallCountException.class, () -> bag.add(redBall1));
    }

    @Test
    void shouldNotAddMoreThan40PercentBallsToBeYellow() {
        Bag bag = new Bag();
        Ball yellowBall1 = new Ball("b1", Color.YELLOW);

        assertThrows(AddingYellowBallException.class, () -> bag.add(yellowBall1));
    }

    @Test
    void shouldAddAYellowBall() throws BallCannotBeAddedException {
        Bag bag = new Bag();
        Ball yellowBall1 = new Ball("b1", Color.YELLOW);
        Ball blueBall1 = new Ball("b2", Color.BLUE);
        Ball blueBall2 = new Ball("b3", Color.BLUE);

        bag.add(blueBall1);
        bag.add(blueBall2);

        assertTrue(bag.add(yellowBall1));
    }

    @Test
    void shouldNotAddBlueBallWhenBlackIsPresent() throws BallCannotBeAddedException {
        Bag bag = new Bag();
        Ball blackBall = new Ball("b1", Color.BLACK);
        Ball blueBall = new Ball("b2", Color.BLUE);

        bag.add(blackBall);

        assertThrows(BallCannotBePresentTogetherException.class, () -> bag.add(blueBall));
    }

    @Test
    void shouldNotAddBlackBallWhenBlueIsPresent() throws BallCannotBeAddedException {
        Bag bag = new Bag();
        Ball blackBall = new Ball("b1", Color.BLACK);
        Ball blueBall = new Ball("b2", Color.BLUE);

        bag.add(blueBall);

        assertThrows(BallCannotBePresentTogetherException.class, () -> bag.add(blackBall));
    }
}