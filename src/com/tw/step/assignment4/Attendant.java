package com.tw.step.assignment4;

public class Attendant implements Receiver{
    @Override
    public void receive(String lotId, double spaceOccupied) {
        if (spaceOccupied < 20) {
            System.out.println("Promote " + lotId);
        }
    }
}
