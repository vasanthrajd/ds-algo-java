package org.algo.twopointers.arrays.hard;

//# Example: nums = [-1,0,1,2,-1,-4]
//# Output: [[-1,-1,2],[-1,0,1]]
// Find all unique Triplet that sum to add up zero

import java.util.Arrays;

/**
 * Problem:
 * Given an integer array nums, return all unique triplets (sets of 3 numbers) such that their sum is 0.
 * The solution must avoid duplicate triplets.
 * * Key Points:
 * Triplet Sum Condition: nums[i] + nums[j] + nums[k] = 0.
 * Uniqueness: No two triplets should contain the same elements in any order (e.g., [-1, 0, 1] and [0, 1, -1] are duplicates). *
 * Efficiency: Brute-force (O(n³)) is unacceptable; optimize using sorting + two-pointer.
 */
public class UniqueSubArray {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        int subArray = 3;
        findUniqueSubArrayWithTargetValue(arr, target);
        arr = new int[]{8, -5, -3, -2, 4, -2, -1, 0, -1};
        findUniqueSubArrayWithTargetValue(arr, target);
        arr = new int[]{2, -2, 0, -2, 2, 0, -3, 2, 1};
        findUniqueSubArrayWithTargetValue(arr, target);
        arr = new int[]{-1, 0, 1, 2, -1, -4};
        int subArraySize = 3;
        findUniqueSubArrayWithTargetValueWithSubArray(arr, target, subArraySize);
        arr = new int[]{8, -5, -3, -2, 4, -2, -1, 0, -1};
        findUniqueSubArrayWithTargetValueWithSubArray(arr, target, subArraySize);
        arr = new int[]{2, -2, 0, -2, 2, 0, -3, 2, 1};
        findUniqueSubArrayWithTargetValueWithSubArray(arr, target, subArraySize);

    }

    /**
     * Need to Revisit this Method Block to add more flexibility
     *
     * @param arr
     * @param target
     * @param subArraySize
     */
    private static void findUniqueSubArrayWithTargetValueWithSubArray(int[] arr, int target, int subArraySize) {
        Arrays.sort(arr);

    }

    private static void findUniqueSubArrayWithTargetValue(int[] arr, int target) {
        Arrays.sort(arr);
        System.out.println("Sorted Array " + Arrays.toString(arr));
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (left + 1 == right) {
                right = (len - 1) - left;
                left++;
                continue;
            }
            // if (!(arr[left] == arr[left+1] && arr[left] == arr[right] && arr[left + 1] == arr[right])) {
            if (arr[left] + arr[left + 1] + arr[right] == target)
                System.out.println(String.format("[%d, %d, %d]", arr[left], arr[left + 1], arr[right]));
            //}
            right--;
        }

    }
}
// [0,1,2]
// [0,1,3]
// [0,1,4]
// [0,1,5]
// [0,2,3]
// [0,2,4]
// [0,2,5]
// [0,3,4]
// [0,3,5]
// [0,4,5]
// [1,2,3]
// [1,2,4]
// [1,2,5]
// [1,3,4]
// [1,3,5]
// [2,3,4]
// [2,3,5]
// [2,4,5]
// [3,4,5]

