package leetcode.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of N integers, your task is to find unique quads that add up to give a target value.
 * In short, you need to return an array of all the
 * unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.
 *
 * Example 1:
 * Input Format:arr[] = [1,0,-1,0,-2,2], target = 0
 * Result: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Explanation:We have to find unique quadruplets from the array such that the sum of those elements is equal to
 * the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.
 *
 * Example 2:
 * Input Format: arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
 * Result: [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
 * Explanation: The sum of all the quadruplets is equal to the target i.e. 9.
 *
 * Note: a, b, c and d are also distinct and lies between 0 to n-1 (both inclusive).
 */
public class FindUniqueQuadsSubArraySumToGivenTarget {
    public static void main(String[] args) {
        int[] arr = new int[] {1,0,-1,0,-2,2};
        int target = 0;
        findUniqueQuadArray(arr, target);
        arr = new int[] {4,3,3,4,4,2,1,2,1,1};
        target = 9;
        findUniqueQuadArray(arr, target);
    }
    // [1,0,-1,0,-2,2]
    // [-2, -1, 0, 0, 1, 2]
    private static void findUniqueQuadsSubArray(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int len = arr.length;
        int left = 0;
        int right = len-1;
        while (left < len) {
            for (int i=right; i>left+1; i--) {
                int sum = arr[left] + arr[left+1] + arr[i-1] + arr[i];
                if (sum == target) {
                    List interimList = Arrays.asList(arr[left], arr[left+1], arr[i-1], arr[i]);
                    list.add(interimList);
                }
            }
            left++;
        }
        System.out.println(list.toString());
    }

    private static void findUniqueQuadArray(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;

            for (int j=i+1; j<arr.length; j++) {
                if (j > i+1 && arr[j] == arr[j-1]) continue;
                int left = j +1;
                int right = arr.length-1;

                while (left < right) {
                    int sum = arr[i]+ arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        List interimList = List.of(arr[i], arr[j], arr[left], arr[right]);
                        list.add(interimList);
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        System.out.println(list.toString());
    }
}
