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
package ch.hslu.sw05.n12.countersimple;

/**
 * Eine Demo für einen einfachen Zähler mit mehreren Threads.
 */
public class DemoSimpleCounter {

    /**
     * Privater Konstruktor.
     */
    private DemoSimpleCounter() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int nThreads = 3;
        final SimpleCounter counter = new SimpleCounter();
        for (int i = 0; i < nThreads; i++) {
            final SimpleCounterTask task = new SimpleCounterTask(counter);
            final Thread thread = new Thread(task, "T" + i + " : ");
            thread.start();
        }
    }
}
