package ch.hslu.sw01.exercise3;

import ch.hslu.sw01.exercise2.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Growth {
    private static final Logger LOG =
            LoggerFactory.getLogger(Tasks.class);

    public static void main(String[] args) {
        var ns = List.of(1, 2, 5, 10, 20, 50, 100);

        LOG.info("log:");
        LOG.info("log:");
        for (Integer n : ns) {
            LOG.info(n + ": " + log(n));
        }

        LOG.info("----------------------");
        LOG.info("id(n):");
        for (Integer n : ns) {
            LOG.info(n + ": " + id(n));
        }

        LOG.info("----------------------");
        LOG.info("n * log(n):");
        for (Integer n : ns) {
            LOG.info(n + ": " + n_log(n));
        }

        LOG.info("----------------------");
        LOG.info("n^2:");
        for (Integer n : ns) {
            LOG.info(n + ": " + n_squared(n));
        }

        LOG.info("----------------------");
        LOG.info("n^3:");
        for (Integer n : ns) {
            LOG.info(n + ": " + n__3(n));
        }

        LOG.info("----------------------");
        LOG.info("2^n:");
        for (Integer n : ns) {
            LOG.info(n + ": " + two_n(n));
        }

        LOG.info("----------------------");
        LOG.info("3^n:");
        for (Integer n : ns) {
            LOG.info(n + ": " + three_n(n));
        }

        LOG.info("----------------------");
        LOG.info("n!:");
        for (Integer n : ns) {
            LOG.info(n + ": " + factorial(n));
        }
    }

    public static double log(int n) {
        return Math.log(n);
    }

    public static double id(int n) {
        return Math.log(n) / Math.log(2);
    }

    public static double n_log(int n) {
        return n * Math.log(n);
    }

    public static double n_squared(int n) {
        return Math.pow(n, 2);
    }

    public static double n__3(int n) {
        return Math.pow(n, 3);
    }

    public static double two_n(int n) {
        return Math.pow(2, n);
    }

    public static double three_n(int n) {
        return Math.pow(2, n);
    }

    public static double factorial(int n) {
        double result = 1;

        for (int factor = 2; factor <= n; factor++) {
            result *= factor;
        }

        return result;
    }
}
