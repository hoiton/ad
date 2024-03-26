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

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Zeichen-Ausgabe auf gemeinsame Ressource Console.
 */
public final class MyTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(MyTask.class);

    @Override
    public final void run() {
        // ...Anweisungen - nebenläufig ausführen
        for (int i = 0; i < 1000; i++) {
            System.out.print("y");
        }
        Thread self = Thread.currentThread();
        LOG.info(" finished {}", self.getName());
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final MyTask myTask = new MyTask();
        Thread.startVirtualThread(myTask);
        for (int i = 0; i < 1000; i++) {
            System.out.print("x");
        }
        final Thread self = Thread.currentThread();
        LOG.info(" finished {}", self.getName());
    }
}
