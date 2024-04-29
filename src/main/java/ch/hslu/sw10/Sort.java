package ch.hslu.sw10;

public class Sort {
    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen-Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static <T extends Comparable<T>> void exchange(final T[] a,
                                 final int firstIndex,
                                 final int secondIndex) {
        T tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    private static <T extends Comparable<T>> void quickSort(final T[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        T t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up].compareTo(t) < 0) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down].compareTo(t) >= 0) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++; down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSort(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }

    public static <T extends Comparable<T>> void quickSort(final T[] a) {
        quickSort(a, 0, a.length - 1);
    }
}
