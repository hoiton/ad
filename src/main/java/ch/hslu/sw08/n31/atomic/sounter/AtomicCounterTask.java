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
package ch.hslu.sw08.n31.atomic.sounter;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Ein Task für den atomaren Zähler.
 */
public final class AtomicCounterTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(AtomicCounterTask.class);

    private final AtomicCounter counter;

    /**
     * Erzeugt einen AtomicCounter Task für Counter Demo.
     *
     * @param counter Counter.
     */
    public AtomicCounterTask(AtomicCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            LOG.info("counter {}", counter.increment());
        }
    }
}
