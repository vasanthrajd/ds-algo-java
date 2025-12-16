package leetcode.arrays.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing both positive and negative integers, we have to find the length of the longest
 * subarray with the sum of all elements equal to zero.
 *
 * Example 1:
 * Input:
 *  N = 6, array[] = {9, -3, 3, -1, 6, -5}
 * Result:
 *  5
 * Explanation:
 *  The following subarrays sum to zero:
 * - {-3, 3}
 * - {-1, 6, -5}
 * - {-3, 3, -1, 6, -5}
 * The length of the longest subarray with sum zero is 5.
 *
 */
public class FindLargestSubArrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = new int[] {9, -3, 3, -1, 6, -5};
        int target = 0;
        findSizeOfLargestSubArray(arr, target);
        arr = new int[] {6, -2, 2, -8, 1, 7, 4, -10};
        findSizeOfLargestSubArray(arr, target);
    }

    private static void findSizeOfLargestSubArray(int[] arr, int target) {
        int max = Integer.MIN_VALUE;
        int len = arr.length;
        int left = 0;
        int right = len-1;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i=0; i<len; i++) {
            sum +=arr[i];
            if (sum == 0) {
                max = i+1;
            } else if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(max);
    }
}
