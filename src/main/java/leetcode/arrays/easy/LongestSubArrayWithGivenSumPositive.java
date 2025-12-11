package leetcode.arrays.easy;

/**
 * Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k.
 * If no such sub-array exists, return 0.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 7, 1, 9], k = 15
 * Output: 4
 * Explanation: The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4.
 * This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15.
 *
 * Therefore, the length of this sub-array is 4.
 *
 */
public class LongestSubArrayWithGivenSumPositive {
    public static void main(String[] args) {
        int[] arr = new int[] {10, 5, 2, 7, 1, 9};
        int k = 15;
        optimalSolution(arr, k);
        arr = new int[] {-3, 2, 1};
        k =6;
        optimalSolution(arr, k);
        arr = new int[]{-1, 1, 1};
        k = 1;
        optimalSolution(arr, k);


    }

    private static void findLongestSubArrayToMatchSum(int[] arr, int k) {
        int longestSubArraySize = 0;
        int left = 0;
        int right = 0;
        int len = arr.length;
        int sum = arr[0];
        while (right < len ) {
           for (int i=left; i< right; i++) {
               sum +=arr[i];
           }
           if (sum == k) {
               longestSubArraySize = (right-left) ;
           } else if (sum > k) {
               left++;
           }
           right++;
           sum=0;
        }
        System.out.println("Longest Sub Array Size is "+ longestSubArraySize);
    }

    private static void optimalSolution(int[] arr, int k) {
        int longestSubArraySize = 0;
        int left = 0;
        int right = 0;
        int len = arr.length;
        int sum = arr[0];
        while (right < len ) {
            while (left < right && sum > k ) {
                sum -=arr[left];
                left++;
            }
            if (sum == k) {
                longestSubArraySize = Math.max(longestSubArraySize, (right-left) +1 );
            }
            right++;
            if (right < len) {
                sum +=arr[right];
            }
        }
        System.out.println("Longest Sub Array Size is "+ longestSubArraySize);
    }
}
