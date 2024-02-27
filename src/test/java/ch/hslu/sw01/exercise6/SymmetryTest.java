package ch.hslu.sw01.exercise6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymmetryTest {
    @Test
    public void getNextSymmetricNumber_numberIsSymmetric_returnsNumber() {
        var result = Symmetry.getNextSymmetricNumber(999);

        assertEquals(999, result);
    }

    @Test
    public void getNextSymmetricNumber_numberIsNotSymmetric_returnsNextSymmetricNumber() {
        var result = Symmetry.getNextSymmetricNumber(123);

        assertEquals(131, result);
    }
}