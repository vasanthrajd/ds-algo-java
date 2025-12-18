package leetcode.arrays.hard;

import java.util.Arrays;

/**
 * Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array,
 * except for A, which appears twice and B which is missing.
 * Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.
 *
 *
 * Example 1:
 * Input:
 *  nums = [3, 5, 4, 1, 1]
 * Output:
 *  [1, 2]
 * Explanation:
 *  1 appears twice in the array, and 2 is missing from the array. So the output is [1, 2].
 *
 * Example 2:
 * Input:
 *  nums = [1, 2, 3, 6, 7, 5, 7]
 * Output:
 *  [7, 4]
 * Explanation:
 *  7 appears twice in the array, and 4 is missing from the array. So the output is [7, 4].
 */
public class FindRepeatingAndMissingNumbers {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 4, 1, 1};
        int[] resultArray = findRepeatingAndMissingNumber(arr);
        System.out.println(Arrays.toString(resultArray));
        arr = new int[] {1, 2, 3, 6, 7, 5, 7};
        resultArray = findRepeatingAndMissingNumber(arr);
        System.out.println(Arrays.toString(resultArray));
    }

    private static int[] findRepeatingAndMissingNumber(int[] arr) {
        int[] missingArray = new int[2];
        int sum = ((arr.length) * (arr.length + 1))/2;
        int runningSum = 0;
        int repeatingNumber = -1;
        for (int i=0; i<arr.length; i++) {
            if (i != arr[i]) {
                repeatingNumber = arr[i];
            }
            runningSum +=arr[i];
        }
        int missingNumber = sum - (runningSum-repeatingNumber);
        missingArray[0] = repeatingNumber;
        missingArray[1] = missingNumber;
        return missingArray;
    }
}
