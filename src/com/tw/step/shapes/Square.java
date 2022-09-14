package com.tw.step.shapes;

public class Square implements Shapes{

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }

    @Override
    public double perimeter() {
        return this.side * 4;
    }
}
