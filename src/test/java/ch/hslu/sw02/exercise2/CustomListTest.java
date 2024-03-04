package ch.hslu.sw02.exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {
    private final CustomList<Integer> testee = new CustomList<>();

    @Test
    public void add_emptyList_addsElement() {
        // Arrange
        final Integer number = 2;

        // Act
        this.testee.add(number);

        // Assert
        assertEquals(number, this.testee.getLast());
        assertEquals(number, this.testee.getStart());
    }

    @Test
    public void add_notEmptyList_addsElement() {
        // Arrange
        final Integer number = 2;
        this.testee.add(18);

        // Act
        this.testee.add(number);

        // Assert
        assertEquals(number, this.testee.getLast());
        assertNotEquals(number, this.testee.getStart());
    }

    @Test
    public void count_emptyList_returnsZero() {
        // Act
        var result = this.testee.size();

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void count_existingItems_returnsSize() {
        // Arrange
        this.testee.add(3);
        this.testee.add(5);
        this.testee.add(5);

        // Act
        var result = this.testee.size();

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void contains_notExistingItem_returnsFalse() {
        // Arrange
        this.testee.add(3);
        this.testee.add(5);
        this.testee.add(5);

        // Act
        var result = this.testee.contains(7);

        // Assert
        assertFalse(result);
    }

    @Test
    public void contains_existingItem_returnsTrue() {
        // Arrange
        this.testee.add(3);
        this.testee.add(5);

        // Act
        var result = this.testee.contains(5);

        // Assert
        assertTrue(result);
    }

    @Test
    public void pop_emptyList_returnsNull() {
        // Act
        var result = this.testee.pop();

        // Assert
        assertNull(result);
    }

    @Test
    public void pop_existingItems_returnsFirstItem() {
        // Arrange
        this.testee.add(3);
        this.testee.add(5);

        // Act
        var result = this.testee.pop();

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void pop_existingItems_removesFirstItem() {
        // Arrange
        this.testee.add(3);
        this.testee.add(5);

        // Act
        this.testee.pop();

        // Assert
        assertEquals(5, this.testee.getStart());
    }

    @Test
    public void remove_emptyList_doesNothing() {
        // Act
        this.testee.remove(5);

        // Assert
        assertEquals(0, this.testee.size());
    }

    @Test
    public void remove_existingItem_removesItem() {
        // Arrange
        this.testee.add(3);
        this.testee.add(5);
        this.testee.add(7);

        // Act
        this.testee.remove(5);

        // Assert
        assertEquals(2, this.testee.size());
        assertFalse(this.testee.contains(5));
    }

    @Test
    public void remove_singleValueList_removesItem() {
        // Arrange
        this.testee.add(3);

        // Act
        this.testee.remove(3);

        // Assert
        assertEquals(0, this.testee.size());
        assertFalse(this.testee.contains(3));
    }

    @Test
    public void remove_duplicateValues_removesAllItems() {
        // Arrange
        this.testee.add(3);
        this.testee.add(5);
        this.testee.add(5);
        this.testee.add(7);

        // Act
        this.testee.remove(5);

        // Assert
        assertEquals(2, this.testee.size());
        assertFalse(this.testee.contains(5));
    }

}