package ch.hslu.sw09;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    private final Integer[] randomized;
    private final Integer[] sorted;

    public SortTest() {
        Random rd = new Random(3); // creating Random object
        final int length = 500_000;
        Integer[] arr = new Integer[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
            System.out.println(arr[i]); // printing each array element
        }

        this.randomized = arr;
        this.sorted = Arrays.stream(arr).sorted().toArray(i -> new Integer[length]);
    }

    @Test
    void randomizedInsertionSort() {
        var start = System.nanoTime();

        Sort.insertionSort(this.randomized);
        var elapsed = System.nanoTime() - start;
        var ms = elapsed / 1_000_000;

        assertArrayEquals(this.sorted, this.randomized);
        System.out.println(ms + "ms for insertionSort");
    }

    @Test
    void testInsertionSort() {
        Integer[] a = new Integer[] { 3, 2, 1, 8, -1};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[] { -1, 1, 2, 3, 8 }, a);
    }

    @Test
    void testInsertionSortEmpty() {
        Integer[] a = new Integer[] {};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[] {}, a);
    }

    @Test
    void testInsertionSortSingle() {
        Integer[] a = new Integer[] { 1 };
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[] { 1 }, a);
    }

    @Test
    void testInsertionSortSorted() {
        Integer[] a = new Integer[] { 1, 2, 3 };
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[] { 1, 2, 3 }, a);
    }


    @Test
    void testShellSort() {
        Integer[] a = new Integer[] { 3, 2, 1, 8, -1};
        Sort.shellSort(a);
        assertArrayEquals(new Integer[] { -1, 1, 2, 3, 8 }, a);
    }

    @Test
    void testShellSortEmpty() {
        Integer[] a = new Integer[] {};
        Sort.shellSort(a);
        assertArrayEquals(new Integer[] {}, a);
    }

    @Test
    void testShellSortSingle() {
        Integer[] a = new Integer[] { 1 };
        Sort.shellSort(a);
        assertArrayEquals(new Integer[] { 1 }, a);
    }

    @Test
    void testShellSortSorted() {
        Integer[] a = new Integer[] { 1, 2, 3 };
        Sort.shellSort(a);
        assertArrayEquals(new Integer[] { 1, 2, 3 }, a);
    }

    @Test
    void randomizedShellSort() {
        var start = System.nanoTime();

        Sort.shellSort(this.randomized);
        var elapsed = System.nanoTime() - start;
        var ms = elapsed / 1_000_000;

        assertArrayEquals(this.sorted, this.randomized);
        System.out.println(ms + "ms for insertionSort");
    }

    @Test
    void randomizedQuickSort() {
        var start = System.nanoTime();

        ch.hslu.sw10.Sort.quickSort(this.randomized);
        var elapsed = System.nanoTime() - start;
        var ms = elapsed / 1_000_000;

        assertArrayEquals(this.sorted, this.randomized);
        System.out.println(ms + "ms for quickSort");
    }
}