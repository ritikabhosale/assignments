package com.tw.step.shapes;

public class Rectangle implements Shapes{

    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
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
