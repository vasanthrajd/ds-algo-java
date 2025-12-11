package leetcode.arrays.medium;

import java.util.Arrays;

/**
 * Problem Statement: Given an array of integers arr[] and an integer target.
 *
 * 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
 *
 * Input: N = 5, arr[] = {2,6,5,8,11}, target = 14
 * Output : YES
 * Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for first variant for second variant output will be : [1,3].
 *
 */
public class CheckGivenPairExist {
    public static void main(String[] args) {
        int[] arr = new int[] {2,6,5,8,11};
        int target = 14;
        System.out.println("Does array have given target for any two index >> " + checkDoesArrayHaveGivenTarget(arr, target));
        System.out.println("Does array have given target for any two index >> " + Arrays.toString(returnIndexThatHaveGivenTarget(arr, target)));
        System.out.println("Does array have given target for any two index >> " + checkDoesArrayHaveGivenTarget(arr, 8));
        System.out.println("Does array have given target for any two index >> " + Arrays.toString(returnIndexThatHaveGivenTarget(arr, 8)));
        System.out.println("Does array have given target for any two index >> " + checkDoesArrayHaveGivenTarget(arr, 12));
        System.out.println("Does array have given target for any two index >> " + Arrays.toString(returnIndexThatHaveGivenTarget(arr, 12)));
        System.out.println("Does array have given target for any two index >> " + checkDoesArrayHaveGivenTarget(arr, 15));
        System.out.println("Does array have given target for any two index >> " + Arrays.toString(returnIndexThatHaveGivenTarget(arr, 15)));
        System.out.println("Does array have given target for any two index >> " + checkDoesArrayHaveGivenTarget(arr, 19));
        System.out.println("Does array have given target for any two index >> " + Arrays.toString(returnIndexThatHaveGivenTarget(arr, 19)));
        System.out.println("Does array have given target for any two index >> " + checkDoesArrayHaveGivenTarget(arr, 13));
        System.out.println("Does array have given target for any two index >> " + Arrays.toString(returnIndexThatHaveGivenTarget(arr, 13)));
    }

    private static String checkDoesArrayHaveGivenTarget(int[] arr, int target) {
        int len = arr.length;
        int left = 0;
        int right = len-1;
        while (left < right) {
            for (int i = right; i > left; i--) {
                if ((arr[left] + arr[i]) == target) {
                    return "YES";
                }
            }
            left++;
        }
        return "NO";
    }

    private static int[] returnIndexThatHaveGivenTarget(int[] arr, int target) {
        int len = arr.length;
        int left = 0;
        int right = len-1;
        while (left < right) {
            for (int i = right; i > left; i--) {
                if ((arr[left] + arr[i]) == target) {
                    return new int[]{left, i};
                }
            }
            left++;
        }
        return new int[]{-1,-1};
    }
}
