package leetcode.recursion;

import java.util.Arrays;

/**
 * Fibonacci Series
 * \(0,1,1,2,3,5,8,13,21,\dots \) and can be defined by the recurrence relation \(F(n)=F(n-1)+F(n-2)\),
 * with the base cases \(F(0)=0\) and \(F(1)=1\)
 */
public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10;
        int x = ' ';
        System.out.println("Ascii " + x);
        int[] arr = new int[n];
        for (int i =0; i < n; i++) {
            arr[i] = fibonacciInRecursion(i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int fibonacciInRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciInRecursion(n-1) + fibonacciInRecursion(n-2);
    }
}
