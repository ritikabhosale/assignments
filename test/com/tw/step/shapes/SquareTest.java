package com.tw.step.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void area() {
        Square square = new Square(3);
        assertEquals(square.area(), 9);
    }

    @Test
    void perimeter() {
        Square square = new Square(3);
        assertEquals(square.perimeter(), 12);
    }
}