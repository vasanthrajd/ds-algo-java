package leetcode.sorting;

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
}
