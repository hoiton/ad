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

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration mit einem Executor, der einen Sortier-Tasks ausführt.
 */
public final class DemoArraySortTask {

    private static final Logger LOG = LoggerFactory.getLogger(DemoArraySortTask.class);

    /**
     * Privater Konstruktor.
     */
    private DemoArraySortTask() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     * @throws java.util.concurrent.ExecutionException wenn bei der
     * Thread-Ausführung ein Fehler passiert.
     */
    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        final byte[] array = new byte[16];
        new Random().nextBytes(array);
        final Callable<byte[]> task = new ArraySortTask(array);
        try (final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            final Future<byte[]> result = executor.submit(task);
            // ...hier was anderes machen
            final byte[] sortedArray = result.get();
            LOG.info("lowest value  = {}", sortedArray[0]);
            LOG.info("highest value = {}", sortedArray[sortedArray.length - 1]);
        } finally {
            // Executor shutdown
        }
    }
}
