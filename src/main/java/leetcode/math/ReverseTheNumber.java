package leetcode.math;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Example 1:
     * Input: x = 123
     * Output: 321
 * Example 2:
     * Input: x = -123
     * Output: -321
 * Example 3:
     * Input: x = 120
     * Output: 21
 */
// Time to Complete 9.24
public class ReverseTheNumber {
    public static void main(String[] args) {
        System.out.println("The Reverse of the Given Number 2446 is >>" + reverseTheGivenNumber(2446));
        System.out.println("The Reverse of the Given Number 123 is >>" + reverseTheGivenNumber(-123));
        System.out.println("The Reverse of the Given Number 120 is >>" + reverseTheGivenNumber(120));
    }

    private static int reverseTheGivenNumber(int n) {
         int  reverseOfNumber = 0;
        while(n !=0 ) {
            int remainder = n % 10;
            reverseOfNumber = remainder +reverseOfNumber * 10;
            n = n/10;
        }
        return reverseOfNumber;
    }

    private static int reverseTheGivenNumberStr(int n) {
        StringBuilder  reverseOfNumber = new StringBuilder();
        while(n !=0 ) {
            int remainder = n % 10;
            reverseOfNumber.append(remainder);
            n = n/10;
        }
        return Integer.parseInt(reverseOfNumber.toString());
    }
}

