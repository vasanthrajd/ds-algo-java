package leetcode.recursion;

/**
 * Given a number ‘N’, find out the sum of the first N natural numbers .
 * Input: N=5
 * Output: 15
 * Explanation: 1+2+3+4+5=15
 *
 * Input: N=6
 * Output: 21
 * Explanation: 1+2+3+4+5+6=15
 */
public class SumoffirstNNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(sumOfFirstNNumbersUsingRecursion(10));
    }
    static int sumOfFirstNNumbersUsingRecursion(int n) {
        if (n==0) {
            return n;
        }
        return n+sumOfFirstNNumbersUsingRecursion(n-1);
    }
}

