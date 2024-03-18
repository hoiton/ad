package ch.hslu.sw04;

import ch.hslu.demo.Point;

public class HashsetTesting {
    public static void main(final String[] args) {
        var hashset = new ListHashset<Integer>();
        hashset.add(0);
        hashset.add(1);
        hashset.add(2);
        hashset.add(3);
        hashset.add(4);
        hashset.add(5);
        hashset.add(6);
        hashset.add(7);
        hashset.add(8);
        hashset.add(16);
        hashset.add(10);
        hashset.add(11);
        hashset.add(12);
        hashset.add(13);
        hashset.add(14);
        hashset.add(15);

        System.out.println(hashset.toString());
        System.out.println(hashset.contains(16));
        hashset.remove(16);
        System.out.println(hashset.toString());
    }
}
