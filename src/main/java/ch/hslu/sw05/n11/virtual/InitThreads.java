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
package ch.hslu.ad.n11.virtual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstration der Instanziierung von virtuellen und konventionellen Threads.
 */
public class InitThreads {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitThreads.class);

    private static long initThreads(final Runnable task, final boolean vThreads) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            if (vThreads) {
                Thread.startVirtualThread(task);
            } else {
                Thread t = new Thread(task);
                t.start();
            }
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        Runnable runnable = () -> {
            // do something...
        };
        LOGGER.info("Time virtual threads: {} msec", initThreads(runnable, true));
        LOGGER.info("Time conven. threads: {} msec", initThreads(runnable, false));
    }
}
