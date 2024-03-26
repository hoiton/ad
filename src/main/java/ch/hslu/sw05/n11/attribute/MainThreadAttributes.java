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
package ch.hslu.ad.n11.attribute;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Anzeige der Attribute des Main-Threads.
 */
public final class MainThreadAttributes {

    private static final Logger LOG = LoggerFactory.getLogger(MainThreadAttributes.class);

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        // Anzahl der Prozessoren abfragen
        final int nr = Runtime.getRuntime().availableProcessors();
        LOG.info("Available processors " + nr);
        // Eigenschaften des main-Threads
        final Thread self = Thread.currentThread();
        LOG.info("Name     : " + self.getName());
        LOG.info("Priority : " + self.getPriority());
        LOG.info("ID       : " + self.threadId());
        LOG.info("Deamon?  : " + self.isDaemon());
    }
}
