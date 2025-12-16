package leetcode.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero.
 * In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]]
 * such that i!=j, j!=k, k!=i, and their sum is equal to zero.
 *
 *
 * Example 1:
 * Input:
 *  nums = [-1,0,1,2,-1,-4]
 * Output:
 *  [[-1,-1,2],[-1,0,1]]
 * Explanation:
 *  Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k
 *
 *  Example 2:
 * Input:
 *  nums=[-1,0,1,0]
 * Output:
 *  Output: [[-1,0,1],[-1,1,0]]
 * Explanation:
 *  Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k
 */
public class FindUniqueTripletsAddToZero {
    public static void main(String[] args) {
        int[] arr = new int[] {-1,0,1,2,-1,-4};
        subArrayWithTargetSumSetToZero(arr);
    }

    private static void subArrayWithTargetSumSetToZero(int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        List<List<Integer>> list = new ArrayList<>();
        while (left < right) {
            for (int i = right; i > left; i--) {
                if ((arr[left] + arr[left +1] + arr[i]) == 0) {
                    List<Integer> tmpLiist = new ArrayList<>();
                    tmpLiist.add(arr[left]);
                    tmpLiist.add(arr[left+1]);
                    tmpLiist.add(arr[i]);
                    list.add(tmpLiist);
                }
            }
            left++;
        }
        System.out.println(list.toString());
    }
}
