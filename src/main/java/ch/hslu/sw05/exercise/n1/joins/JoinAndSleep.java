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
package ch.hslu.sw05.exercise.n1.joins;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration von Join und Sleep - Aufgabe 3 - N1_EX_ThreadsSynch.
 */
public class JoinAndSleep {
    
    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleep.class);
    
    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn Warten unterbrochen wird.
     */
    public static void main(String[] args) throws InterruptedException {
        var thread3 = new JoinAndSleepTask("Task 3", 4000);
        var thread2 = new JoinAndSleepTask("Task 2", 3000);
        var thread1 = new JoinAndSleepTask("Task 1", 2000);

        var t3 = new Thread(thread3);
        var t2 = new Thread(thread2);
        var t1 = new Thread(thread1);
        
        LOG.info("Main-Thread beendet.");

        t1.join();
    }
}
