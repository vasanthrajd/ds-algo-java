package leetcode.strings;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 */
public class MergeStringInAlternatively {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeStringAlternatively(word1, word2));
        word1 = "ab";
        word2 = "pqrs";
        System.out.println(mergeStringAlternatively(word1, word2));
        word2 = "ab";
        word1 = "pqrs";
        System.out.println(mergeStringAlternatively(word1, word2));
    }

    private static String mergeStringAlternatively(String word1, String word2) {
        StringBuilder mergeString = new StringBuilder();
        int lowerLen = word1.length()> word2.length() ? word2.length() : word1.length();
        for (int i=0; i<lowerLen; i++) {
            mergeString.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (word1.length() != word2.length()) {
            String higherLen = word1.length() > word2.length() ? word1 : word2;
            mergeString.append(higherLen.substring(lowerLen));
        }
        return mergeString.toString();
    }
}
