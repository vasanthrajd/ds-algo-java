package leetcode.arrays.easy;

import java.util.Arrays;

public class ArrangeOddAndEvenNumbersInArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        arrangeOddNumbersAndEventNumbersByPointers(arr);
    }

    private static void arrangeOddNumbersAndEventNumbersI(int[] arr) {
        int[] newArray = new int[arr.length];
        int left = 0;
        int right = arr.length-1;
        for (int i=0; i<arr.length && left <= right; i++) {
            if (arr[i] %2 == 0) {
                newArray[left] = arr[i];
                left++;
            } else {
                newArray[right] = arr[i];
                right--;
            }
        }
        System.out.println(Arrays.toString(newArray));
    }

    private static void arrangeOddNumbersAndEventNumbersByPointers(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            if (arr[left] %2 != 0 ) {
                if (arr[right] %2 == 0) {
                    int temp = arr[right];
                    arr[right] = arr[left];
                    arr[left] = temp;
                    right--;
                    left++;
                } else {
                    right--;
                }
            } else {
                left++;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
