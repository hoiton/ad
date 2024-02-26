package ch.hslu.sw01.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;

public class Tasks {
    private static final Logger LOG =
            LoggerFactory.getLogger(Tasks.class);
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            task(i);
        }
    }
    
    public static void task(final int n) throws InterruptedException {
        counter = 0;
        var begin = Instant.now();
        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2(); task2(); task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3(); task3(); // T ~ n · n· 2
            }
        }

        LOG.info("task(" + n + "); Counter: " + counter  + "; Time: " + Duration.between(begin, Instant.now()).getSeconds() + "s");
    }

    private static void task1() throws InterruptedException {
        counter++;
        Thread.sleep(10);
    }

    private static void task2() throws InterruptedException {
        counter++;
        Thread.sleep(10);
    }

    private static void task3() throws InterruptedException {
        counter++;
        Thread.sleep(10);
    }
}
