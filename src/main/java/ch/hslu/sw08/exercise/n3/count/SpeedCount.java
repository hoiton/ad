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
package ch.hslu.sw08.exercise.n3.count;

import java.util.ArrayList;
import java.util.concurrent.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Speed-Test für unterschiedlich impementierte Counters.
 */
public final class SpeedCount {

    private static final Logger LOG = LoggerFactory.getLogger(ch.hslu.sw08.exercise.n3.count.SpeedCount.class);

    /**
     * Privater Konstruktor.
     */
    private SpeedCount() {
    }

    /**
     * Test für einen Counter.
     * @param counter Zählertyp.
     * @param counts Anzahl Zähl-Vorgänge.
     * @param threads Anzahl Tester-Threads.
     * @return Dauer des Tests in mSec.
     */
    public static long speedTest(Counter counter, int counts, int threads) {
        try (final ExecutorService executor = Executors.newCachedThreadPool()) {
            var start = System.nanoTime();
            var futures = new ArrayList<Future<Integer>>();

            for (int i = 0; i < threads; i++) {
                Future<Integer> future = executor.submit(new CountTask(counter, counts));
                futures.add(future);
            }

            for (Future<Integer> future : futures) {
                future.get();
            }

            if (counter.get() != 0) {
                throw new IllegalStateException("Counter test failed: " + counter.get() + " != 0");
            }

            var elapsed = System.nanoTime() - start;
            return elapsed / 1_000_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            // Executor shutdown
        }
    }

    /**
     * Main-Counter-Test.
     * @param args not used.
     */
    public static void main(final String args[]) {
        final int passes = 20;
        final int threads = 12;
        final int counts = 1_0000;
        final Counter counterSync = new SynchronizedCounter();
        long sumSync = 0;
        speedTest(counterSync, counts, threads);
        for (int i = 0; i < passes; i++) {
            sumSync += speedTest(counterSync, counts, threads);
        }
        final Counter counterAtom = new AtomicCounter();
        long sumAtom = 0;
        speedTest(counterAtom, counts, threads);
        for (int i = 0; i < passes; i++) {
            sumAtom += speedTest(counterAtom, counts, threads);
        }
        if (counterSync.get() == 0) {
            LOG.info("Sync counter ok");
            LOG.info("Sync counter average test duration = {} ms", sumSync / (float) passes);
        } else {
            LOG.info("Sync counter failed");
        }
        if (counterAtom.get() == 0) {
            LOG.info("Atom counter ok");
            LOG.info("Atom counter average test duration = {} ms", sumAtom / (float) passes);
        } else {
            LOG.info("Atom counter failed");
        }
    }
}
