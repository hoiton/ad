package ch.hslu.sw13;

import java.util.Arrays;
import java.util.HashMap;

public class QuickSearch {
    public static int QuickSearch(String value, String pattern) {
        var foundAt = -1;
        var valueLength = value.length();
        var patternLength = pattern.length();
        final int range = 256; // Ascii Range
        // ASCII-Range
        final int[] shift = new int[range];
        // init shift-array
        Arrays.fill(shift, patternLength + 1);

        // set shift value for each character in pattern
        for (int i = 0; i < patternLength; i++) {
            shift[pattern.charAt(i)] = patternLength - i;
        }

        // search
        var index = 0;
        var patternIndex = 0;
        do {
            if (value.charAt(index + patternIndex) == pattern.charAt(patternIndex)) {
                // Match
                patternIndex++;
            }
            else {
                if ((index + patternLength) < valueLength) {
                    index += shift[value.charAt(index + patternLength)];
                    patternIndex = 0;
                }
                else {
                    break;
                }
            }
        } while (patternIndex < patternLength && (index + patternIndex) < valueLength);

        return index;
    }
}
