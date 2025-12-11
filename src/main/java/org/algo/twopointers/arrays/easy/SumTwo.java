package org.algo.twopointers.arrays.easy;

//1. Given a sorted array, find two numbers that add up to a target value.
//2. Find two lines that form a container holding the most water.
//3. Find all unique triplets that sum to zero.

import java.util.Arrays;

public class SumTwo {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int targetNumber = 19;
        int[] result = findTwoNumbersWhichEqualsToGivenTargetFromSortedArray(sortedArray, targetNumber);
        String formattedMessage = String.format(
                "For the given Target %s the numbers which add up to this one is %s ",targetNumber, Arrays.toString(result));
        System.out.println(formattedMessage);
        result = findTwoNumbersWhichEqualsToGivenTargetFromSortedArrayWithSingleLoop(sortedArray, targetNumber);
        formattedMessage = String.format(
                "For the given Target %s the numbers which add up to this one is %s ",targetNumber, Arrays.toString(result));
        System.out.println(formattedMessage);
    }

    // It uses two for loop to arrive at the result,

    /**
     * Find two numbers in a sorted array that add up to a target value.
     *
     * @param nums:   a sorted array of integers
     * @param target: the target sum to find
     * @return : array of two integers that add up to the target, or an empty array if no such pair exists
     */
    public static int[] findTwoNumbersWhichEqualsToGivenTargetFromSortedArray(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int len = nums.length;
        for (; (left < len); left++) {
            boolean exit = false;
            for (int right = left + 1; right < len; right++) {
                int tempSum = nums[left] + nums[right];
                if (tempSum == target) {
                    result[0] = nums[left];
                    result[1] = nums[right];
                    exit = true;
                    break;
                }
            }
            if (exit) {
                break;
            }
        }
        return result;
    }


    public static int[] findTwoNumbersWhichEqualsToGivenTargetFromSortedArrayWithSingleLoop(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length -1;
        int len = nums.length;
        if (nums[right] + nums[right] == target) {
            return new int[] {nums[right], nums[right]};
        }
        //for(;left < len;) {
        while(true) {
            int tempSum = nums[left] + nums[right];
            if (tempSum == target) {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            } else if (tempSum < target) {
                left ++;
            } else {
                right --;
            }
        }
        return result;
    }
}
