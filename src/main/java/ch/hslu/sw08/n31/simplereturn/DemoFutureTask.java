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
package ch.hslu.sw08.n31.simplereturn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration mit Callable und FutureTask.
 */
public final class DemoFutureTask {

    private static final Logger LOG = LoggerFactory.getLogger(DemoFutureTask.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFutureTask() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     * @throws java.util.concurrent.ExecutionException wenn bei der
     * Thread-Ausführung ein Fehler passiert.
     */
    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        final Callable<Integer> sumTask = () -> {
            int sum = 0;
            for (int i = 1; i <= 10_000; i++) {
                sum += i;
            }
            return sum;
        };
        final FutureTask<Integer> futureSumTask = new FutureTask<>(sumTask);
        Thread.startVirtualThread(futureSumTask);
        LOG.info("Summe: " + futureSumTask.get());
    }
}
