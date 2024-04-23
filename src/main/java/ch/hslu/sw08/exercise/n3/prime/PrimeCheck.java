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
package ch.hslu.sw08.exercise.n3.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 100 grosse Primzahlen finden.
 */
public final class PrimeCheck {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheck.class);

    /**
     * Privater Konstruktor.
     */
    private PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final int nThreads = 12;
        final AtomicInteger n = new AtomicInteger(0);
        try (var executor = Executors.newFixedThreadPool(nThreads)) {
            for (int i = 0; i < nThreads; i++) {
                executor.submit(() -> {
                    while (n.get() < 100) {
                        BigInteger bi = new BigInteger(1024, new Random());
                        if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                            synchronized (n) {
                                if (n.get() < 100)
                                {
                                    n.incrementAndGet();
                                    LOG.info("{} : {}...", n, bi.toString().substring(0, 20));
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
