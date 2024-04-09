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

/**
 * Thread-sicherer Zähler.
 */
public final class SynchronizedCounter {

    private int counter = 0;

    /**
     * Zähler um 1 addieren.
     *
     * @return gibt den neuen Zählerstand zurück.
     */
    public synchronized int increment() {
        return counter++;
    }

    /**
     * Zähler um 1 subtrahieren.
     *
     * @return gibt den neuen Zählerstand zurück.
     */
    public synchronized int decrement() {
        return counter--;
    }

    /**
     * Liefert den Zählerstand.
     *
     * @return aktueller Zählerstand.
     */
    public synchronized int get() {
        return counter;
    }
}
