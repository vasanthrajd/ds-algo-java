package leetcode.sorting.ordernpower2sorrting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[] {13,46,24,52,20,9};
        int n = array.length;
        for (int i = n-1; i >=0; i--) {
            for (int j = 0; j<i; j++) {
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }


    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        // Outer loop to traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Inner loop to perform the comparison and swapping
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if the current element
                // is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
