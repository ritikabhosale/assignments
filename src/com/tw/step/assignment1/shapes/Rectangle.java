package com.tw.step.assignment1.shapes;

public class Rectangle implements Shape {

    private final double width;
    private final double length;

    private Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public static Rectangle createRectangle(double width, double length) {
        return new Rectangle(width, length);
    }

    public static Rectangle createSquare(double side) {
        return new Rectangle(side, side);
    }

    @Override
    public double area() {
        return  this.length * this.width;
    }

    @Override
    public double perimeter(){
        return 2 *(this.length + this.width);
    }
}
