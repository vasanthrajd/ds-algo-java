package leetcode.sorting.ordernpower2sorrting;

import java.util.Arrays;

/**
 * Given an array of N integers, write a program to implement the Selection sorting algorithm.
 * Input: N = 6, array[] = {13,46,24,52,20,9}
 * Output: 9,13,20,24,46,52
 * Explanation: After sorting the array is: 9, 13, 20, 24, 46, 52
 */
public class SelectionSorting {
    public static void main(String[] args) {
        int[] array = new int[] {13,46,24,52,20,9};
        int n = array.length;
        for (int i=0; i<n ; i++) {
            int minIndex = i;
            for (int j=i+1; j<n; j++) {
                if (array[j] < array[i]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
