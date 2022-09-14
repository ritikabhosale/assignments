package com.tw.step.rectangle;

public class Rectangle {

    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }


    public double area() {
        return  this.length * this.width;
    }
}
