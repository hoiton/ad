package ch.hslu.sw01.exercise7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Symmetry {
    private static final Logger LOG =
            LoggerFactory.getLogger(Symmetry.class);

    public static void main(String[] args) {
        LOG.info("Symmetrische 1-Stellige Zahlen: " + amountOfSymmetricNumbers(1));
        LOG.info("Symmetrische 2-Stellige Zahlen: " + amountOfSymmetricNumbers(2));
        LOG.info("Symmetrische 3-Stellige Zahlen: " + amountOfSymmetricNumbers(3));
        LOG.info("Symmetrische 4-Stellige Zahlen: " + amountOfSymmetricNumbers(4));
        LOG.info("Symmetrische 5-Stellige Zahlen: " + amountOfSymmetricNumbers(5));
        LOG.info("Symmetrische 6-Stellige Zahlen: " + amountOfSymmetricNumbers(6));
        LOG.info("Symmetrische 7-Stellige Zahlen: " + amountOfSymmetricNumbers(7));
        LOG.info("Symmetrische 8-Stellige Zahlen: " + amountOfSymmetricNumbers(8));
//        LOG.info("Symmetrische 9-Stellige Zahlen: " + numberOfSymmetricNumbers(9));

    }

    public static int amountOfSymmetricNumbers(int amountOfDigits) {
        var lower = (int) Math.pow(10, amountOfDigits - 1);
        var upper = lower * 10;

        if (lower == 1) return 10;

        var numberOfSymmetricNumbers = 0;
        for (int i = lower; i < upper; i++) {
            if (isSymmetric(i))
                numberOfSymmetricNumbers++;
        }

        return numberOfSymmetricNumbers;
    }

    public static int getNextSymmetricNumber(int number) {
        while (!isSymmetric(number)) {
            number++;
        }

        return number;
    }

    /**
     * Beschreibung des Algorithmus:
     * Falls Zahl eine Länge von 1 hat, ist die Zahl immer symmetrisch.
     * Falls nicht, wird das erste Zeichen mit dem letzten Zeichen verglichen. Wenn diese nicht übereinstimmen,
     * ist die Zahl nicht symmetrisch.
     * Weiter wird der Index vom Anfang der Zahl inkrementiert und der Index vom Ende der Zahl dekrementiert.
     * Die Zeichen an den neuen Indexen werden verglichen.
     * Das geht so weiter bis die Indexe sich in der Mitte getroffen haben.
     *
     * @param number Nummer, welche auf Symmetrie geprüft werden soll
     * @return True, wenn number symmetrisch ist
     */
    public static boolean isSymmetric(Integer number) {
        var numberString = number.toString();

        if (numberString.length() == 1) return true;

        var currentIndex = 0;

        var maxIndex = numberString.length() - 1;
        while ((maxIndex / 2) >= currentIndex) {
            if (numberString.charAt(currentIndex) != numberString.charAt(maxIndex - currentIndex))
                return false;

            currentIndex++;
        }

        return true;
    }
}
