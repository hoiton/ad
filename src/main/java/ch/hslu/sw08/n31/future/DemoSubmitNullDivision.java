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
package ch.hslu.sw08.n31.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration mit einem Executor, der einen "fehlerhaften" einem Task erhält.
 */
public class DemoSubmitNullDivision {

    private static final Logger LOG = LoggerFactory.getLogger(DemoSubmitNullDivision.class);

    /**
     * Privater Konstruktor.
     */
    private DemoSubmitNullDivision() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    @SuppressWarnings("divzero")
    public static void main(final String[] args) {
        try (final ExecutorService executor = Executors.newCachedThreadPool()) {
            final Future<?> future = executor.submit(() -> {
                try {
                    System.out.println(1 / 0); // nur zu Demonstration!
                } catch (Exception ex) {
                    LOG.debug(ex.getMessage(), ex);
                    throw ex;
                }
            });
            try {
                future.get();
            } catch (InterruptedException | ExecutionException ex) {
                LOG.debug(ex.getMessage(), ex);
            }
        } finally {
            // Executor shutdown
        }
    }
}
