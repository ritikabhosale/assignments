package com.tw.step.assignment4.exception;

public class ParkingLotsNotEmptyException extends Throwable {
    @Override
    public String getMessage() {
        return "Parking lots are not empty";
    }
}
