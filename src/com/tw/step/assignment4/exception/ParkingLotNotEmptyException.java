package com.tw.step.assignment4.exception;

public class ParkingLotNotEmptyException extends Throwable {
    @Override
    public String getMessage() {
        return "Parking lot is not empty";
    }
}
