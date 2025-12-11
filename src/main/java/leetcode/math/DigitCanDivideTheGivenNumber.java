package leetcode.math;

/**
 * Given a positive integer n, count the number of digits in n that divide n evenly
 * (i.e., without leaving a remainder). Return the total number of such digits.
 *
 * A digit d of n divides n evenly if the remainder when n is divided by d is 0 (n % d == 0).
 * Digits of n should be checked individually. If a digit is 0, it should be ignored because division by 0 is undefined.
 *
 * Input: n = 12
 * Output: 2
 * Explanation: 1, 2 when both divide 12 leaves remainder 0.
 * Input: n = 2446
 * Output: 1
 * Explanation: Here among 2, 4, 6 only 2 divides 2446 evenly while 4 and 6 do not.
 */
// Time to Complete : 7.3 Min
public class DigitCanDivideTheGivenNumber {
    public static void main(String[] args) {
        System.out.println(" The Number of Digits in the Given Number that divides the number  " +
                findCountOfDigitsThatDivideTheGivenNumber(2446));
        System.out.println(" The Number of Digits in the Given Number that divides the number  " +
                findCountOfDigitsThatDivideTheGivenNumber(12));
    }

    private static int findCountOfDigitsThatDivideTheGivenNumber(int n) {
        int count=0;
        int k = n;
        while(k != 0) {
            int remainder = k%10;
            k = k / 10;
            if (n%remainder == 0) {
                count++;
            }
        }
        return count;
    }
}
