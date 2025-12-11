package leetcode.slinding_window_2_pointers.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, S. Find the length of the longest substring without repeating characters.-
 *
 * Example 1:
 * Input: S = "abcddabac"
 * Output: 4
 * Explanation: The longest substring with distinct characters is "abcd", which has a length of 4.
 *
 * Example 2:
 * Input: S = "aaabbbccc"
 * Output: 2
 * Explanation: The longest substrings with distinct characters are "ab" and "bc", both having a length of 2.
 */
public class LongSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcddabac";
        System.out.println("find the longest substring with unique value >> " + longestSubStringFromTheArray(str));
        str = "aaabbbccc";
        System.out.println("find the longest substring with unique value >> " + longestSubStringFromTheArray(str));
        str = "geeksforgeeks";
        System.out.println("find the longest substring with unique value >> " + longestSubStringFromTheArray(str));
        str = "abcdefabcbb";
        System.out.println("find the longest substring with unique value >> " + longestSubStringFromTheArray(str));
    }

    private static int longestSubStringFromTheArray(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int longestStringCount = 0;
        int count = 0;
        for (int i=0; i< str.length(); i++) {
            Character ch = str.charAt(i);
            if (map.containsKey(ch)) {
                count=0;
                map.clear();
            } else {
                map.put(ch, 1);
                count++;
                longestStringCount = Math.max(longestStringCount, count);
            }

        }
        return longestStringCount;
    }
}
