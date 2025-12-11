package org.algo.twopointers.arrays.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem Statement:
 * Given two strings s and t, find the smallest substring in s that contains all characters of t
 * (including duplicates).
 * Return the substring if found; otherwise, return an empty string.
 * Key Requirements: *
 * Containment: The window must include every character of t at least as frequently as in t.
 * Optimality: If multiple valid windows exist, return the smallest one.
 * Example:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC" (Explanation: The shortest substring containing A, B, and C.)
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String input = "ADOBECODEBANC";
        String searchString = "ABC";
        String subString = findMinimumSubString(input, searchString);
        System.out.println("SubString  = " + subString);
    }

    private static String findMinimumSubString(String input, String searchString) {
        Map<Character, Long> mapOfTChar = searchString.chars().mapToObj(operand -> (char) operand)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int left = 0;
        int right = searchString.length();
        int len = input.length();
        String smallSubString = "";
        int formed = 0;
        Map<Character, Long> currentWindowMap = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while (right < len) {
            char c = input.charAt(right);
            currentWindowMap.put(c, currentWindowMap.getOrDefault(c, 0L) + 1);
            if (mapOfTChar.containsKey(c) && Objects.equals(mapOfTChar.get(c), currentWindowMap.get(c))) {
                formed++;
            }
            while (left < right && formed == mapOfTChar.size()) {
                c = input.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                currentWindowMap.put(c, currentWindowMap.get(c) - 1);
                if (mapOfTChar.containsKey(c) && currentWindowMap.get(c).intValue() < mapOfTChar.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : input.substring(ans[1], ans[2] + 1);
    }
}
