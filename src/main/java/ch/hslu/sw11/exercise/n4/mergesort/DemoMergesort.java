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
package ch.hslu.sw11.exercise.n4.mergesort;

import ch.hslu.sw09.Sort;
import ch.hslu.sw11.n41.array.init.RandomInitTask;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import ch.hslu.util.AsciiTable;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class DemoMergesort {

    private static final Logger LOG = LoggerFactory.getLogger(ch.hslu.sw11.exercise.n4.mergesort.DemoMergesort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoMergesort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {

        AsciiTable table = new AsciiTable();
        table.setMaxColumnWidth(45);

        table.getColumns().add(new AsciiTable.Column("Threshold"));
        table.getColumns().add(new AsciiTable.Column("Conc. Mergesort (ms)"));
        table.getColumns().add(new AsciiTable.Column("Mergesort Rec. (ms)"));



        final int size = 10_000_000;
        final int[] arrayOriginal = new int[size];
        try (final ForkJoinPool pool = new ForkJoinPool()) {
            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);

            for (int value : List.of( 20, 5, 10, 40, 50, 60, 70, 80, 100, 500, 1000, 5000, 10000)) {

                MergesortTask.THRESHOLD = value;

                AsciiTable.Row row = new AsciiTable.Row();
                table.getData().add(row);

                if (value == 20) {
                    row.getValues().add("Warmup");
                } else {
                    row.getValues().add("" + value);
                }
                int[] array = Arrays.copyOf(arrayOriginal, size);

                var start = System.nanoTime();
                final MergesortTask sortTask = new MergesortTask(array);
                pool.invoke(sortTask);
                var elapsed = System.nanoTime() - start;
                var ms = elapsed / 1_000_000;
                row.getValues().add("" + ms);

                start = System.nanoTime();
                array = Arrays.copyOf(arrayOriginal, size);
                MergesortRecursive.mergeSort(array);
                elapsed = System.nanoTime() - start;
                ms = elapsed / 1_000_000;
                row.getValues().add("" + ms);
            }
        } finally {
            // Executor shutdown
        }


        table.calculateColumnWidth();
        table.render();
    }
}
