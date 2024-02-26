package ch.hslu.sw01.exercise4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    public void fiboRec1_zero_returnsZero() {
        // Arrange
        final int n = 0;

        // Act
        var result = Fibonacci.fiboRec1(n);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void fiboRec1_one_returnsOne() {
        // Arrange
        final int n = 1;

        // Act
        var result = Fibonacci.fiboRec1(n);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void fiboRec1_fifteen_returns610() {
        // Arrange
        final int n = 15;

        // Act
        var result = Fibonacci.fiboRec1(n);

        // Assert
        assertEquals(610, result);
    }

    @Test
    public void fiboRec2_zero_returnsZero() {
        // Arrange
        final int n = 0;

        // Act
        var result = Fibonacci.fiboRec2(n);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void fiboRec2_one_returnsOne() {
        // Arrange
        final int n = 1;

        // Act
        var result = Fibonacci.fiboRec2(n);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void fiboRec2_fifteen_returns610() {
        // Arrange
        final int n = 15;

        // Act
        var result = Fibonacci.fiboRec2(n);

        // Assert
        assertEquals(610, result);
    }
}