package org.algo.twopointers.arrays.medium;

import java.util.Arrays;

public class FindSecondLargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 0, 2, 0, 6, 0, 2, 3};
        int secondLargest = findSecondLargestNumber(nums);
        System.out.println("Second Largest from the given array "+ secondLargest);
    }

    private static int findSecondLargestNumber(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-2];
    }
}
