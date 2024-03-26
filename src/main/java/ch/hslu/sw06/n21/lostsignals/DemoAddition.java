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
package ch.hslu.ad.n21.lostsignals;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demo Lost Signals. Eine Addition gesteuert mit wait - notify.
 */
public final class DemoAddition {

    private static final Logger LOG = LoggerFactory.getLogger(DemoAddition.class);
    private static final Object LOCK = new Object();
    private static long sum = 0;

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws java.lang.InterruptedException falls Unterbruch beim Warten.
     */
    public static void main(final String args[]) throws InterruptedException {
        // Thread addiert...
        Thread.startVirtualThread(() -> {
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            LOG.info("calc finished, notifing...");
            synchronized (LOCK) {
                LOCK.notify();
            }
        });
        // Thread wartet auf Summe...
        Thread sumThread = Thread.startVirtualThread(() -> {
            LOG.info("wait for result...");
            synchronized (LOCK) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            LOG.info("sum = " + sum);
        });
        // auf Ausgabe warten...
        sumThread.join();
    }
}
