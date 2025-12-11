package leetcode.arrays.medium;

/**
 * Kadane's Algorithm
 * Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: nums = [2, 3, 5, -2, 7, -4]
 * Output: 15
 * Explanation: The subarray from index 0 to index 4 has the largest sum = 15, which is the maximum sum of any contiguous subarray.
 *
 * Example 2:
 * Input: nums = [-2, -3, -7, -2, -10, -4]
 * Output: -2
 * Explanation: The largest sum is -2, which comes from taking the element at index 0 or index 3 as the subarray.
 * Since all numbers are negative, the subarray with the least negative number gives the largest sum.
 *
 */
public class MaxSubArraySumInAArray {
    public static void main(String[] args) {
        int[] arr = new int[] {-2, -3, -7, -2, -10, -4};
        System.out.println("Maximum Sum From different Sub Array is >> "+ bruteForceMethod(arr));
        System.out.println("Maximum Sum From different Sub Array is Optimal >> "+ maxSubArray(arr));
        arr = new int[] {2, 3, 5, -2, 7, -4};
        System.out.println("Maximum Sum From different Sub Array is >> "+ bruteForceMethod(arr));
        System.out.println("Maximum Sum From different Sub Array is Optimal >> "+ maxSubArray(arr));
    }
    private static int findMaximumNumberOfASubArray(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = 0;
        int sum = arr[left];
        while (right < len) {
            int internalSum = arr[right];
            if (internalSum > sum) {
                sum = internalSum;
            }
            for (int i=left; i<right; i++) {
                internalSum += arr[i];
            }
            if (internalSum > sum) {
                sum = internalSum;
                left++;
            }
            right++;
        }
        return sum;
    }

    private static int bruteForceMethod(int[] arr) {
        int len = arr.length;
        int sum = arr[0];
        for (int i=0; i<len; i++) {
            int internalSum = arr[i];
            if (internalSum > sum) {
                sum = internalSum;
            }
            for (int j=i+1; j<len; j++) {
                internalSum +=arr[j];
                if (internalSum > sum) {
                    sum = internalSum;
                }
            }
        }
        return sum;
    }

    public static int maxSubArray(int[] nums) {

        // Maximum sum
        long maxi = Long.MIN_VALUE;

        // Current sum of subarray
        long sum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Add current element to the sum
            sum += nums[i];

            // Update maxi if current sum is greater
            if (sum > maxi) {
                maxi = sum;
            }

            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the maximum subarray sum found
        return (int) maxi;
    }
}
