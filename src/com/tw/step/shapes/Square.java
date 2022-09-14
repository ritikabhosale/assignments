package com.tw.step.shapes;

public class Square {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return this.side * 4;
    }
}
