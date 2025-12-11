package leetcode.arrays.medium;

/**
 *Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Input : N = 4, array[] = {3, 1, 2, 4}, k = 6
 * Output: 2
 * Explanation: The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].
 *
 * Input: N = 3, array[] = {1,2,3}, k = 3
 * Output: 2
 * Explanation: The subarrays that sum up to 3 are [1, 2], and [3].
 */
public class CountSubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = new int[] {3,1,2,4};
        int k = 6;
        System.out.println("Number of Sub Array which match with the sum " +k + " is >>" + findNumberOfSubArrayMatchingGivenK(nums, k));
        nums = new int[] {3,1,2};
        k = 3;
        System.out.println("Number of Sub Array which match with the sum " +k + " is >>" + findNumberOfSubArrayMatchingGivenK(nums, k));
    }

    private static int findNumberOfSubArrayMatchingGivenK(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        int left = 0;
        int right = left +1;
        while (left < len) {
            int sum =nums[left];
            if (sum == k) count++;
            for (int i = left+1; i < len; i++) {
                sum += nums[i];
                if (sum == k) {
                    count++;
                }
            }
            left++;
        }
        return count;

    }
}
