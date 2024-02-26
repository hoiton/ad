package ch.hslu.sw01.exercise4;

import ch.hslu.sw01.exercise2.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private static final List<Long> fibonacciCache = new ArrayList<Long>(200);

    private static final Logger LOG =
            LoggerFactory.getLogger(Tasks.class);

    public static void main(String[] args) {
    }

    public static long fiboRec1(int n) {
        // Rekursionsbasis
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Rekursionsvorschrift
        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    public static long fiboRec2(int n) {
        // Rekursionsbasis
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (n >= fibonacciCache.size()) {
            for (int i = 0; i <= n; i++) {
                fibonacciCache.add(null);
            }
        }

        if(n >= fibonacciCache.size() || fibonacciCache.get(n) == null){
            // Rekursionsvorschrift
            var fibN = fiboRec1(n - 1) + fiboRec1(n - 2);
            fibonacciCache.set(n, fibN);
            return fibN;
        }else{
            return fibonacciCache.get(n);
        }

    }

    public static long fiboIter(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        var minusTwo = 0;
        var minusOne = 1;

        for (int i = 2; i < n; i++) {
            var current = minusTwo + minusOne;
            minusTwo = minusOne;
            minusOne = current;
        }

        return minusOne + minusTwo;
    }
}
