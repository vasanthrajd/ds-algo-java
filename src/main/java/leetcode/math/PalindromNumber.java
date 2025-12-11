package leetcode.math;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.*
 * Example 1:
 *      Input: x = 121
 * Output: true
 *  Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 *
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Could you solve it without converting the integer to a string?
 */
public class PalindromNumber {
    public static void main(String[] args) {
        System.out.println(convertGivenNumberToPalindrome(121));
        System.out.println(convertGivenNumberToPalindrome(-121));
        System.out.println(convertGivenNumberToPalindrome(10));
    }

    private static String convertGivenNumberToPalindrome(int i) {
        int palindromeNumber =0;
        if (i < 0) {
            return "Negative number is not Palindrome " + i + " == " +  palindromeNumber + " " + false;
        }
        int processNumber = i;
        while (processNumber != 0) {
            int remainder = processNumber % 10;
            palindromeNumber = remainder + palindromeNumber  * 10;
            processNumber = processNumber / 10;
        }
        boolean result = palindromeNumber == i;
        return "Is given number Palindrome " + i + " == " +  palindromeNumber + " " + result;
    }
}
