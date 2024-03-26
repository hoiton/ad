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
package ch.hslu.ad.n12.countersingle;

/**
 * Ein globaler Zähler, der eineindeutige Werte liefert.
 */
public class SingleCounter {

    private static int globalCount = 0;

    /**
     * Erhöht den aktuellen globalen Zählerwert um Eins und gibt diesen zurück.
     *
     * @return Zählerwert.
     */
    public static synchronized int increment() {
        globalCount++;
        return globalCount;
    }
}
