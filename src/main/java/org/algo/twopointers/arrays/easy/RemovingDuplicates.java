package org.algo.twopointers.arrays.easy;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array (Easy)
 * Remove duplicates in-place and return the new length.
 * 1. Remove Duplicates from Sorted Array (Easy)
 * Problem Statement:
 * Given a sorted integer array nums, remove duplicate elements in-place
 * (without extra space) such that each unique element appears only once.
 * Return the new length of the modified array.

 * Key Requirements:
 * In-place Modification: Overwrite duplicates in the original array.
 * Relative Order: Maintain the original order of unique elements.
 * Return New Length: The array beyond the returned length can be ignored.
 * Example:
 * Input: nums = [1, 1, 2, 2, 3]
 * Output: 3 (New array: [1, 2, 3, _, _])
 */
public class RemovingDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3};
        System.out.println("Length of Array after removing duplicates "+ removeDuplicateFromArray(nums));
        nums = new int[]{2,3,4,4,5,6,6,7,7};
        System.out.println("Length of Array after removing duplicates "+ removeDuplicateFromArray(nums));
        nums = new int[]{1,1,1,1,3,3,3,4,4};
        System.out.println("Length of Array after removing duplicates "+ removeDuplicateFromArray(nums));
    }

    private static String removeDuplicateFromArray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = left + 1;
        while(right < len) {
            if (nums[left] != nums[right]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }

        return String.valueOf(left+1);
    }
}
