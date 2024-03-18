package ch.hslu.sw04;

import ch.hslu.sw01.exercise2.Tasks;
import ch.hslu.sw02.exercise3.CustomStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class StackPerformanceTesting {
    private static final Logger LOG =
            LoggerFactory.getLogger(StackPerformanceTesting.class);
    public static void main(final String[] args) {

        final int runs = 1000;

        LOG.info("Warmup (size: 100'000, runs: 1'000)");
        int size = 100_000;
        var testData = generateTestData(size);
        var one = testDefaultStack(runs, size, testData);
        var two = testCustomtStack(runs, size, testData);
        LOG.info("Difference: " + formatInterval(one - two));

        LOG.info("Run 1 (size: 100'000, runs: 1'000)");
        one = testDefaultStack(runs, size, testData);
        two = testCustomtStack(runs, size, testData);
        LOG.info("Difference: " + formatInterval(one  - two));

        LOG.info("Run 2 (size: 1'000'000, runs: 1'000)");
        size = 1_000_000;
        testData = generateTestData(size);
        one = testDefaultStack(runs, size, testData);
        two = testCustomtStack(runs, size, testData);
        LOG.info("Difference: " + formatInterval(one-two));

        LOG.info("Run 2 (size: 100'000, runs: 1'000)");
        size = 100_000;
        testData = generateTestData(size);
        one = testDefaultStack(runs, size, testData);
        two = testCustomtStack(runs, size, testData);
        LOG.info("Difference: " + formatInterval(one-two));

//        var stack = new CustomStack<TestData>(size);
//        for (int i = 0; i < size; i++) {
//            stack.push(testData[i]);
//        }
//        for (int i = 0; i < size; i++) {
//            stack.pop();
//        }
    }

    private static long testCustomtStack(int runs, int size, TestData[] testData) {
        var runtimes = new long[runs];
        for (int i = 0; i < runs; i++) {
            runtimes[i] = testDefaultStackInternal(size, testData);
        }

        var test = (long) Arrays.stream(runtimes).asDoubleStream().average().orElse(0);

        LOG.info("Custom stack: " + formatInterval(test));
        return test;
    }

    private static long testCustomStackInternal(int size, TestData[] testData) {

        var stack = new CustomStack<TestData>(size);
        var start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            stack.push(testData[i]);
        }
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
        var end = System.nanoTime();
        return end - start;
    }


    private static long testDefaultStack(int runs, int size, TestData[] testData) {
        var runtimes = new long[runs];
        for (int i = 0; i < runs; i++) {
            runtimes[i] = testDefaultStackInternal(size, testData);
        }


        var test = (long) Arrays.stream(runtimes).asDoubleStream().average().orElse(0);

        LOG.info("Custom stack: " + formatInterval(test));
        return test;
    }

    private static long testDefaultStackInternal(int size, TestData[] testData) {

        var stack = new Stack<TestData>();
        var start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            stack.push(testData[i]);
        }
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
        var end = System.nanoTime();
        return end - start;
    }

    private static String formatInterval(final long nanos)
    {
        var duration = Duration.ofNanos(nanos);

        var formattedElapsedTime = String.format("%02d Second %d Millisecond %d Nanosecond",
                duration.toSecondsPart(),
                duration.toMillisPart(), duration.toNanosPart() % 1000000L);
        return formattedElapsedTime;

//        final long hr = TimeUnit.NANOSECONDS.toHours(nanos);
//        final long min = TimeUnit.NANOSECONDS.toMinutes(nanos - TimeUnit.HOURS.toNanos(hr));
//        final long sec = TimeUnit.NANOSECONDS.toSeconds(nanos - TimeUnit.HOURS.toNanos(hr) - TimeUnit.MINUTES.toNanos(min));
//        final long ms = TimeUnit.NANOSECONDS.toNanos(nanos - TimeUnit.HOURS.toNanos(hr) - TimeUnit.MINUTES.toNanos(min) - TimeUnit.SECONDS.toNanos(sec));
//        return String.format("%02d:%02d:%02d.%09d", hr, min, sec, ms);
    }

    private static TestData[] generateTestData(int size) {
        var data = new TestData[size];
        for (int i = 0; i < size; i++) {
            data[i] = new TestData(i);
        }
        return data;
    }

    private static class TestData {
        private final int value;
        private final String test;

        public TestData(Integer value) {
            this.value = value;
            this.test = value.toString() + "test";
        }
    }
}
