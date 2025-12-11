package leetcode.math;

/**
 * Given a positive integer n, The task is to find the value of Σi F(i) where i is from 1 to n and
 * function F(i) is defined as the sum of all divisors of i.
 *
 * Examples:
 *
 * Input: n = 4
 * Output: 15
 * Explanation:
 * F(1) = 1
 * F(2) = 1 + 2 = 3
 * F(3) = 1 + 3 = 4
 * F(4) = 1 + 2 + 4 = 7
 * So, F(1) + F(2) + F(3) + F(4)
 */
public class SumOfAllDivisor {
    public static void main(String[] args) {
        System.out.println("Print sum of all divisor >> " + getAllDivisorSum(6));
        System.out.println("Print sum of all divisor >> " + getAllDivisorSum(5));
    }

    private static long getAllDivisorSum(int N) {
        long sum = 0;

        // Loop through each integer from 1 to N
        for (int i = 1; i <= N; i++) {
            // Add the product of i and the number of multiples of i up to N
            sum += i * (N / i);
            System.out.println("Sum value after i-th Iteration " + i + " >> "  + sum );
        }

        // Return the total sum of all divisors
        return sum;
    }
}
