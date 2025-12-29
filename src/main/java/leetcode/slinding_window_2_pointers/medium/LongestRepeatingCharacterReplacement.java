package leetcode.slinding_window_2_pointers.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer k and a string s, any character in the string can be selected and changed to any
 * other uppercase English character.
 *
 * This operation can be performed up to k times.
 *
 * After completing these steps, return the length of the longest substring
 *
 * that contains the same letter.
 *
 * Input: s = "BAABAABBBAAA", k = 2
 * Output: 6
 * Explanation: We can change the B at index 0 and 3 (0-based indexing) to A.
 * The new string becomes "AAAAAABBBAAA".
 * The substring "AAAAAA" is the longest substring with the same letter,
 * and its length is 6.
 *
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: We can change one character to get the new string "AABBBBA".
 * The substring "BBBB" is the longest with the same character.
 * There are other ways to achieve this result as well.
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "BAABAABBBAAA";
        int k =2;
        System.out.println("Longest repeating character replacement >> " + longestRepeatingCharacterReplacementWithCharComparsion(str, k));
        str = "AABABBA";
        k =3;
        System.out.println("Longest repeating character replacement >> " + longestRepeatingCharacterReplacementWithCharComparsion(str, k));
    }

    // Inconsistent Result
    private static int longestRepeatingCharacterReplacement(String str, int k) {
        int count=0;
        int len = str.length();
        int previousIndex = 0;
        int runningCount = k;
        for (int i=0, j=i+1; j < len; i++, j++) {
            boolean compareResult = str.charAt(i) != str.charAt(j);
            if (compareResult) {
                runningCount--;
            }
            if (runningCount == -1) {
                count = Math.max(count, j-previousIndex);
                runningCount = k;
                previousIndex = i;
            }
        }
        return count;
    }

    private static int longestRepeatingCharacterReplacementWithCharComparsion(String str, int k) {
        int[] freq = new int[26];
        int left = 0, right = 0;
        int maxCount = 0;
        int maxLength = 0;
        while (right < str.length()) {
            freq[str.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[str.charAt(right) - 'A']);
            while ((right - left + 1) - maxCount > k) {
                freq[str.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;

    }
}
