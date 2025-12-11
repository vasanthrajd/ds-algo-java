package leetcode.recursion;

/**
 * Given a string, check if the string is palindrome or not. A string is said to be palindrome if the reverse of the string is the same as the string.
 *
 * Example 1:
 * Input: Str =  “ABCDCBA”
 * Output: Palindrome
 * Explanation: String when reversed is the same as string.
 */
public class PalindromeString {
    public static void main(String[] args) {
        String str = "ABCDCBA";
        System.out.println(recursionForPalindrome(str, new StringBuilder(), str.length(), 0));
        str = "MALAYALAM";
        System.out.println(recursionForPalindrome(str, new StringBuilder(), str.length(), 0));
    }

    private static String recursionForPalindrome(String str, StringBuilder palindromeStr, int length, int index) {
        if (index == str.length()) {
            if (str.contentEquals(palindromeStr)) {
                return "PALINDROME";
            } else {
                return "NOT PALINDROME";
            }
        } else {
            palindromeStr.append(str.charAt(length-1));
            index +=1;
            length -=1;
            return recursionForPalindrome(str, palindromeStr, length, index);
        }
    }
}
