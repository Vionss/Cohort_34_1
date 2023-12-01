package ait.map.word;

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String word, String part) {
        // TODO Homework

        if (word == null || part == null || word.isEmpty() || part.isEmpty()) {
            return false;
        }

        char[] wordChars = word.toLowerCase().toCharArray();
        char[] partChars = part.toLowerCase().toCharArray();

        Arrays.sort(wordChars);
        Arrays.sort(partChars);

        return Arrays.equals(wordChars, partChars);
    }
}