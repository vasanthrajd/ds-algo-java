package leetcode.recursion;

/**
 * Given an integer N, write a program to print numbers from N to 1.
 * Input: N = 4
 * Output: 4, 3, 2, 1
 * Explanation: All the numbers from 4 to 1 are printed.
 *
 * Input: N = 1
 * Output: 1
 * Explanation: This is the base case.
 */
public class PrintNTo1UsingRecursion {
    public static void main(String[] args) {
        printNto1UsingRecursion(5);
    }

    private static void printNto1UsingRecursion(int i) {
        if (i==0) {
            return;
        } else {
            System.out.println(i);
            printNto1UsingRecursion(i-1);

        }
    }

}
