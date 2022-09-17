package com.tw.step.assignment4;

public interface Receiver {

    void receive(String lotId, double spaceOccupied);

    boolean receiveNotificationOn(String lotId, double spaceOccupied);
}
