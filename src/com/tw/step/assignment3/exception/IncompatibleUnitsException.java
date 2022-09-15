package com.tw.step.assignment3.exception;

public class IncompatibleUnitsException extends Throwable {
    @Override
    public String getMessage() {
        return "Incompatible Units.";
    }
}
