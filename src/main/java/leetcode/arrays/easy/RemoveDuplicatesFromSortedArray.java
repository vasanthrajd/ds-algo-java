package leetcode.arrays.easy;

import java.util.Arrays;

/**
 * Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 *
 * Input: arr[]=[1,1,2,2,2,3,3]
 * Output: [1,2,3,_,_,_,_]
 * Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.
 *
 *
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,2,2,3,3};
        int len = arr.length;
        int[] returnArray = new int[arr.length];
        returnArray[0] = arr[0];
        int trackIndex = 1;
        for (int i=1; i < len; i++) {
            if (arr[i-1] != arr[i]) {
                returnArray[trackIndex] = arr[i];
                trackIndex++;
            }
        }
        for (;trackIndex < len; trackIndex++) {
            returnArray[trackIndex] = '_';
        }
        System.out.println(Arrays.toString(returnArray));
    }
}
