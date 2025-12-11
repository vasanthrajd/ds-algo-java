package leetcode.strings;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Example 2: *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 *
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 *
 */
public class GreatestCommonDivisorOfString {
    public static void main(String[] args) {
        String str1 = "LEET";
        String str2 = "CODE";
        System.out.println(findGCDofTwoString(str1, str2));
    }
    private static String findGCDofTwoString(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        int str1Len = str1.length();
        int str2Len = str2.length();
        while(str2Len != 0) {
            int temp = str2Len;
            str2Len = str1Len % str2Len;
            str1Len = temp;
        }
        return str1.substring(str1Len);
    }
}
