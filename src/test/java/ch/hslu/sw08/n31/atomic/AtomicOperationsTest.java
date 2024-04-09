/* 
 * Copyright 2024 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw08.n31.atomic;

import ch.hslu.sw08.n31.atomic.ops.AtomicOperations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Testfälle für {@link ch.hslu.sw08.n31.atomic.ops.AtomicOperations}.
 */
class AtomicOperationsTest {

    /**
     * Test of updateWrong method, of class AtomicOperations.
     */
    @Test
    void testUpdateWrong() {
        AtomicOperations.setValue(12L);
        long newVal = 42L;
        AtomicOperations.updateWrong(newVal);
        long result = AtomicOperations.getValue();
        assertEquals(newVal, result);
    }

    /**
     * Test of updateCorrect method, of class AtomicOperations.
     */
    @Test
    void testUpdateCorrect() {
        AtomicOperations.setValue(12L);
        long newVal = 42L;
        AtomicOperations.updateCorrect(newVal);
        long result = AtomicOperations.getValue();
        assertEquals(newVal, result);
    }

    /**
     * Test of update method, of class AtomicOperations.
     */
    @Test
    void testUpdate() {
        AtomicOperations.setValue(12L);
        long newVal = 42L;
        AtomicOperations.update(newVal);
        long result = AtomicOperations.getValue();
        assertEquals(newVal, result);
    }

    /**
     * Test of add method, of class AtomicOperations.
     */
    @Test
    void testAddV1() {
        AtomicOperations.setValue(12L);
        long operand = 30L;
        AtomicOperations.add(operand);
        long result = AtomicOperations.getValue();
        assertEquals(42L, result);
    }

    /**
     * Test of mult method, of class AtomicOperations.
     */
    @Test
    void testMultV1() {
        AtomicOperations.setValue(21L);
        long operand = 2L;
        AtomicOperations.mult(operand);
        long result = AtomicOperations.getValue();
        assertEquals(42L, result);
    }

    /**
     * Test of add method, of class AtomicOperations.
     */
    @Test
    void testAddV2() {
        AtomicOperations.setValue(12L);
        long operand = 30L;
        long result = AtomicOperations.add(operand);
        assertEquals(12L, result);
    }

    /**
     * Test of mult method, of class AtomicOperations.
     */
    @Test
    void testMultV2() {
        AtomicOperations.setValue(21L);
        long operand = 2L;
        long result = AtomicOperations.mult(operand);
        assertEquals(21L, result);
    }

}
