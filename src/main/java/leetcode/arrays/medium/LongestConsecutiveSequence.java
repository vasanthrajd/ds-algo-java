package leetcode.arrays.medium;

import java.util.Arrays;

/**
 * Given an array nums of n integers.
 * Return the length of the longest sequence of consecutive integers.
 * The integers in this sequence can appear in any order.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence of Number >> " + longestConsecutiveSequence(nums));
        nums = new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Sequence of Number >> " + longestConsecutiveSequence(nums));
    }

    private static int longestConsecutiveSequence(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int max = 0;
        int left = 0;
        int len = nums.length;
        while (left +1 < len) {
            if (nums[left] +1 == nums[left+1]) {
                count++;
            }
            max = Math.max(count, max);
            left++;

        }
        return max;

    }
}
