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
package ch.hslu.sw11.exercise.n4.quicksort;

import ch.hslu.sw11.n41.array.init.RandomInitTask;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LoggerFactory.getLogger(ch.hslu.sw11.exercise.n4.quicksort.DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 10_000;
        final int[] arrayOriginal = new int[size];
        try (final ForkJoinPool pool = new ForkJoinPool()) {
            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);

            int[] arrayTask = Arrays.copyOf(arrayOriginal, size);
            var start = System.nanoTime();
            final QuicksortTask sortTask = new QuicksortTask(arrayTask);
            pool.invoke(sortTask);
            var elapsed = System.nanoTime() - start;
            var ms = elapsed / 1_000_000_000.0;
            LOG.info("QuicksortTask  : {} sec.", ms);


            int[] arrayRec = Arrays.copyOf(arrayOriginal, size);
            start = System.nanoTime();
            QuicksortRecursive.quicksort(arrayRec);
            elapsed = System.nanoTime() - start;
            ms = elapsed / 1_000_000_000.0;
            LOG.info("QuicksortRec.  : {} sec.", ms);


            int[] arraySort = Arrays.copyOf(arrayOriginal, size);
            start = System.nanoTime();
            Arrays.sort(arraySort);
            elapsed = System.nanoTime() - start;
            ms = elapsed / 1_000_000_000.0;
            LOG.info("Arrays.sort    : {} sec.", ms);
        } finally {
            // Executor shutdown
        }
    }
}
