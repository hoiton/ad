package ch.hslu.sw10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeHeapTest {
    private final FixedSizeHeap testee;

    public FixedSizeHeapTest() {
        testee = new FixedSizeHeap(20);
    }

    @Test
    void testInsert() {
        testee.insert(5);
        testee.insert(10);
        testee.insert(15);
        testee.insert(20);
        testee.insert(25);
        testee.insert(30);
        testee.insert(35);
        testee.insert(40);
        testee.insert(45);
        testee.insert(50);
        testee.insert(55);
        testee.insert(60);
        testee.insert(65);
        testee.insert(70);
        testee.insert(75);
        testee.insert(80);
        testee.insert(85);
        testee.insert(90);
        testee.insert(95);
        testee.insert(100);
        assertThrows(IllegalStateException.class, () -> testee.insert(105));
    }

    @Test
    void testGetMax() {
        testee.insert(5);
        testee.insert(10);
        testee.insert(15);
        testee.insert(20);
        testee.insert(25);
        testee.insert(30);
        testee.insert(35);
        testee.insert(40);
        testee.insert(45);
        testee.insert(50);
        testee.insert(55);
        testee.insert(60);
        testee.insert(65);
        testee.insert(70);
        testee.insert(75);
        testee.insert(80);
        testee.insert(85);
        testee.insert(90);
        testee.insert(95);
        testee.insert(100);
        assertEquals(100, testee.getMax());
    }

    @Test
    void testPopMax() {
        testee.insert(5);
        testee.insert(10);
        testee.insert(15);
        testee.insert(20);
        testee.insert(25);
        testee.insert(30);
        testee.insert(35);
        testee.insert(40);
        testee.insert(45);
        testee.insert(50);
        testee.insert(55);
        testee.insert(60);
        testee.insert(65);
        testee.insert(70);
        testee.insert(75);
        testee.insert(80);
        testee.insert(85);
        testee.insert(90);
        testee.insert(95);
        testee.insert(100);
        assertEquals(100, testee.popMax());
        assertEquals(95, testee.popMax());
    }

    @Test
    void randomOrderInsert() {
        testee.insert(50);
        testee.insert(20);
        testee.insert(90);
        testee.insert(30);
        testee.insert(10);
        testee.insert(100);
        testee.insert(80);
        testee.insert(40);
        testee.insert(60);
        testee.insert(70);
        assertEquals(100, testee.popMax());
        assertEquals(90, testee.popMax());
        assertEquals(80, testee.popMax());
    }
}