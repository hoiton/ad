package ch.hslu.sw01.exercise5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ackermann {
    private static final Logger LOG =
            LoggerFactory.getLogger(Ackermann.class);

    private static int aufrufe;

    public static void main(String[] args) {
        long result = 0;
        try {
            result = ack(4, 2);
        } catch (StackOverflowError e) {
            LOG.error("Aufrufe: " + aufrufe, e);
        }

        LOG.info("Result: " + result);
        LOG.info("Aufrufe von ack(): " + aufrufe);
    }

    public static long ack(long n, long m) {
        aufrufe++;

        if (n == 0) return m + 1;
        if (m == 0) return ack(n - 1, 1);

        // nicht primitiv rekursiv, weil ack(ack()) -> mehrere Aufrufe
        return ack(n - 1, ack(n, m - 1));
    }
}
