/*
 * Copyright 2024 Hochschule Luzern Informatik.
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
package ch.hslu.sw08.n31.future.arraysort;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Sortieren eines Arrays.
 */
public final class ArraySortTask implements Callable<byte[]> {

    private final byte[] array;

    /**
     * Erzeugt ein Array Sortierer
     *
     * @param array zu sortierendes Array
     */
    public ArraySortTask(final byte[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public byte[] call() {
        Arrays.sort(array);
        return array;
    }
}
