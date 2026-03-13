package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        String baseString = "cbaebabacd", testString = "abc";

    }

    public static List<Integer> findAnagrams(String baseString, String testString) {
        List<Integer> result = new ArrayList<>();
        if (baseString.length() < testString.length()) return result;

        // Frequency map of characters in p
        Map<Character, Integer> testCharMap = new HashMap<>();
        for (char c : testString.toCharArray()) {
            testCharMap.put(c, testCharMap.getOrDefault(c, 0) + 1);
        }

        // Frequency map for the current window in s
        Map<Character, Integer> baseCountMap = new HashMap<>();
        int windowSize = testString.length();

        // Initialize the window with the first 'windowSize' characters of s
        for (int i = 0; i < windowSize; i++) {
            baseCountMap.put(baseString.charAt(i), baseCountMap.getOrDefault(baseString.charAt(i), 0) + 1);
        }

        // Iterate over s
        for (int i = 0; i < baseString.length() - windowSize + 1; i++) {
            // Compare frequency maps
            if (testCharMap.equals(baseCountMap)) result.add(i);

            // Slide the window forward:
            // Remove the old character going out of the window
            char oldChar = baseString.charAt(i);
            baseCountMap.put(oldChar, baseCountMap.get(oldChar) - 1);
            if (baseCountMap.get(oldChar) == 0) baseCountMap.remove(oldChar);

            // Add the new character coming into the window
            if (i + windowSize < baseString.length()) {
                char newChar = baseString.charAt(i + windowSize);
                baseCountMap.put(newChar, baseCountMap.getOrDefault(newChar, 0) + 1);
            }
        }

        return result;
    }

    public List<Integer> findAnagramsByArray(String baseStr, String anagramStr) {
        List<Integer> result = new ArrayList<>();
        if (baseStr.length() < anagramStr.length()) return result;

        // Frequency arrays for s and p
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Initialize the frequency arrays
        for (int i = 0; i < anagramStr.length(); i++) {
            pCount[anagramStr.charAt(i) - 'a']++;
            sCount[baseStr.charAt(i) - 'a']++;
        }

        // Sliding window over s
        for (int i = 0; i <= baseStr.length() - anagramStr.length(); i++) {
            // Check if the current window is an anagram
            if (areArraysEqual(pCount, sCount)) result.add(i);

            // Slide the window
            if (i + anagramStr.length() < baseStr.length()) {
                sCount[baseStr.charAt(i) - 'a']--; // Remove old char from the count
                sCount[baseStr.charAt(i + anagramStr.length()) - 'a']++; // Add new char to the count
            }
        }

        return result;
    }

    private boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
