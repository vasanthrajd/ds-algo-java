package leetcode.sorting.ordernpower2sorrting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[] {46,13,24,52,20,9};
        int n = array.length;

        for (int i=1; i<n; i++) {
            int key = array[i];
            int j = i-1;
            while (j>=0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        System.out.println(Arrays.toString(array));

    }
}
