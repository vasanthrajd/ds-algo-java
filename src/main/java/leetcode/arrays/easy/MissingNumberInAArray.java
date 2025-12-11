package leetcode.arrays.easy;

import java.util.Arrays;

/**
 * Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N.
 * Find the number(between 1 to N), that is not present in the given array.
 * Example 1:
 * Input Format: N = 5, array[] = {1,2,4,5}
 * Result: 3
 */
public class MissingNumberInAArray {
    public static void main(String[] args) {
        int[] arr = new int[]  {1,2,3,4};
        int n=5;
        System.out.println("Missing number in given Array " + Arrays.toString(arr) + "  "+ findMissingNumberInAArray(arr, n));
        arr = new int[]  {1,2,3};
        n=4;
        System.out.println("Missing number in given Array " + Arrays.toString(arr) + "  "+ findMissingNumberInAArray(arr, n));
    }

    private static int findMissingNumberInAArray(int[] arr, int limitOfNumbers) {
        int len = arr.length;
        int result = -1;
        for (int i=0; i <= limitOfNumbers-1; i++) {
            if (len == i) {
                result = i+1;
                break;
            }
            System.out.println("Comparing " + (i+1) + " with " + arr[i]);

            if (i + 1 != arr[i]) {
                result = i+1;
                break;
            }
        }
        return result;
    }




}
