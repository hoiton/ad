package ch.hslu.sw02.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {
    private final CustomStack<Integer> stack = new CustomStack<>(5);

    @Test
    public void push_emptyStack_addsElement() {
        // Arrange
        final Integer number = 2;

        // Act
        stack.push(number);

        // Assert
        assertEquals(number, stack.peek());
    }

    @Test
    public void push_fullStack_throwsException() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> stack.push(6));
    }

    @Test
    public void pop_notEmptyStack_removesElement() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        var result = stack.pop();

        // Assert
        assertEquals(3, result);
        assertEquals(2, stack.peek());
    }

    @Test
    public void pop_emptyStack_throwsException() {
        // Act & Assert
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void peek_notEmptyStack_returnsElement() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        var result = stack.peek();

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void peek_emptyStack_throwsException() {
        // Act & Assert
        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    public void isEmpty_emptyStack_returnsTrue() {
        // Act
        var result = stack.isEmpty();

        // Assert
        assertTrue(result);
    }

    @Test
    public void isEmpty_notEmptyStack_returnsFalse() {
        // Arrange
        stack.push(1);

        // Act
        var result = stack.isEmpty();

        // Assert
        assertFalse(result);
    }

    @Test
    public void isFull_fullStack_returnsTrue() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Act
        var result = stack.isFull();

        // Assert
        assertTrue(result);
    }

    @Test
    public void isFull_notFullStack_returnsFalse() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Act
        var result = stack.isFull();

        // Assert
        assertFalse(result);
    }
}