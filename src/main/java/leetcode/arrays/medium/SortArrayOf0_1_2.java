package leetcode.arrays.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order.
 * The sorting must be done in-place, without making a copy of the original array.
 *
 * Input: nums = [1, 0, 2, 1, 0]
 * Output: [0, 0, 1, 1, 2]
 * Explanation: The nums array in sorted order has 2 zeroes, 2 ones and 1 two
 */
public class SortArrayOf0_1_2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 0, 2, 1, 0};
        sortArrayInPlace(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[] {1,2,0,1,2,0,0,1,2,1,1};
        sortArrayInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArrayInPlace(int[] arr) {
        int len = arr.length;
        int low = 0;
        int mid = 0;
        int high = len-1;
        while (mid < high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

    }
}
