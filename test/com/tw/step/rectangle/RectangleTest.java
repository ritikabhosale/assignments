package com.tw.step.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void area() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(rectangle.area(), 12);
    }

    @Test
    void perimeter() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(rectangle.perimeter(), 14);
    }

    @Test
    void calculatePerimeterForFloatingDimensions() {
        Rectangle rectangle = new Rectangle(2.5, 3.2);
        assertEquals(rectangle.perimeter(), 11.4);
    }
}