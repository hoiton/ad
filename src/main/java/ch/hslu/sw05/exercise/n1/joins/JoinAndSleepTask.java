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
 * Parametrierbarer Task, der auf einen fremden Thread wartet und danach für
 * eine bestimmte Zeit schläft.
 */
public class JoinAndSleepTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleepTask.class);
    private final String taskName;
    private Thread joinFor;
    private final int sleepTime;

    /**
     * Erzeugt einen Task mit Namen.
     * 
     * @param taskName der Name des Tasks.
     * @param sleepTime die Zeit in mSec die der Task schläft.
     */
    public JoinAndSleepTask(final String taskName, final int sleepTime) {
        this.taskName = taskName;
        this.joinFor = null;
        this.sleepTime = sleepTime;
    }

    public JoinAndSleepTask join(final Thread joinFor) {
        this.joinFor = joinFor;
        return this;
    }

    public Thread getThread() {
        return Thread.currentThread();
    }

    /**
     * Hier wird auf das Ende des fremden Threads gewartet und danach für eine
     * bestimmte Zeit geschlafen. Beide Teile können unterbrochen werden.
     */
    @Override
    public void run() {
        LOG.info(taskName + " gestartet");
        if (joinFor != null) {
            try {
                LOG.info(taskName + " wartet auf " + joinFor.getName());
                joinFor.join();
            } catch (InterruptedException ex) {
                LOG.error(ex.getMessage());
            }
            LOG.info(taskName + " ist aufgewacht");
        }

        try {
            LOG.info(taskName + " schläft für " + sleepTime + " mSec: Sleepy time");
            Thread.sleep(sleepTime);
            LOG.info(taskName + " fertig");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
