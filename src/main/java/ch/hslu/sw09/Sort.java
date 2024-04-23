package ch.hslu.sw09;

import java.util.ArrayList;

public class Sort {
    public static <T extends Comparable<T>> void insertionSort(final T[] a) {
        for (int i = 1; i < a.length; i++) {
            final T element = a[i];
            int swapper = i;
            while (swapper > 0 && element.compareTo(a[swapper - 1]) < 0) {
                a[swapper] = a[swapper - 1];
                a[swapper - 1] = element;
                swapper--;
            }

            a[swapper] = element;
        }
    }

    public static <T extends Comparable<T>> void shellSort(final T[] a) {
        final int length = a.length;
        int n = 1;
        while (hibbard(n + 1) <= length) {
            n++;
        }

        // Iterate over the Steps in the Hibbard sequence
        for (int i = n; i >= 1; i--) {
            final int step = hibbard(i);

            // Apply Sort for each Step-Size-Sublist
            for (int k = 0; k < step; k++) {

                // Insertion sort the sublist
                for (int j = k + step; j < length; j += step) {
                    final T element = a[j];
                    int swapper = j;
                    while (swapper - step >= 0 && element.compareTo(a[swapper - step]) < 0) {
                        a[swapper] = a[swapper - step];
                        a[swapper - step] = element;
                        swapper -= step;
                    }

                    a[swapper] = element;
                }
            }
        }
    }

//    public static <T extends Comparable<T>> void shellSort(final T[] a) {
//        final int length = a.length;
//        int n = 1;
//        while (hibbard(n + 1) <= length) {
//            n++;
//        }
//
//        for (int i = n; i >= 1; i--) {
//            final int step = hibbard(i);
//            for (int k = 0; k + step < length; k++) {
//                final ArrayList<T> sublist = new ArrayList<>();
//                for (int j = k; j < a.length; j += step) {
//                    sublist.add(a[j]);
//                }
//
//                insertionSort(sublist.toArray(i -> a));
//            }
//        }
//
//    }

    private static int hibbard(final int n) {
        return (int) (Math.pow(2, n) - 1);
    }
}

