package leetcode.math;

import java.util.Arrays;

import static org.apache.commons.math3.util.ArithmeticUtils.gcd;

/**
 * Given two integers a and b, You have to compute their LCM and GCD and return an array containing their LCM and GCD.
 *
 * Examples:
 *
 * Input: a = 5 , b = 10
 * Output: [10, 5]
 * Explanation: LCM of 5 and 10 is 10, while their GCD is 5.
 *
 * Input: a = 14 , b = 8
 * Output: [56, 2]
 * Explanation: LCM of 14 and 8 is 56, while their GCD is 2.
 */
public class LcdAndGcdOfAnInteger {
    public static void main(String[] args) {
        System.out.println("LCD and GCD of Two Number is >>" + Arrays.toString(findLCDAndGCDOfGivenTwoNumbers(14,8)));
        System.out.println("LCD and GCD of Two Number is >>" + Arrays.toString(findLCDAndGCDOfGivenTwoNumbers(8, 14)));
    }

    private static int[] findLCDAndGCDOfGivenTwoNumbers(int i, int j) {
        int gcd = gcd(i,j);
        int lcd = (i *j)/gcd;
        return new int [] {gcd, lcd};

    }
    private static int gcd(int i, int j) {
        while (j !=0 ) {
            int temp = i % j;
            i = j ;
            j = temp;
        }
        return i;
    }
}


