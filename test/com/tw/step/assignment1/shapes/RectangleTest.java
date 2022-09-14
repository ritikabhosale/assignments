package com.tw.step.assignment1.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void calculateAreaForRectangle() {
        Rectangle rectangle = Rectangle.createRectangle(3, 4);
        assertEquals(rectangle.area(), 12);
    }

    @Test
    void calculatePerimeterForRectangle() {
        Rectangle rectangle = Rectangle.createRectangle(3, 4);
        assertEquals(rectangle.perimeter(), 14);
    }

    @Test
    void calculatePerimeterForFloatingDimensions() {
        Rectangle rectangle = Rectangle.createRectangle(2.5, 3.2);
        assertEquals(rectangle.perimeter(), 11.4);
    }

    @Test
    void calculateAreaForSquare() {
        Rectangle square = Rectangle.createSquare(3);
        assertEquals(square.area(), 9);
    }

    @Test
    void calculatePerimeterForSquare() {
        Rectangle square = Rectangle.createSquare(3);
        assertEquals(square.perimeter(), 12);
    }
}