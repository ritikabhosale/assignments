package com.tw.step.assignment4.exception;

public class LotNotEmptyException extends Throwable {
    @Override
    public String getMessage() {
        return "Lot is not empty";
    }
}
