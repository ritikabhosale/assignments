package com.tw.step.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void area() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(rectangle.area(), 12);
    }
}