package com.tw.step.assignment3;

public enum LengthUnit {
    FEET, INCH, MM;

    public double inCentimeters() {
        switch (this.name()) {
            case "FEET" : return 30;
            case "INCH" : return 2.5;
            case "MM" : return 0.1;
        }
        return 0;
    }
}
