package leetcode.arrays;

import java.util.HashMap;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Example 3:
 *
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 *
 */
public class ContingousArray {
    public static void main(String[] args) {
        System.out.println("Longest Continous Sub Array " + findLongestSubCount(new int[]{0,1}));
        System.out.println("Longest Continous Sub Array " +findLongestSubCount(new int[]{0,1,0}));
        System.out.println("Longest Continous Sub Array " +findLongestSubCount(new int[]{0,1,1,1,1,1,0,0,0}));
        System.out.println("Longest Continous Sub Array " +findLongestSubCount(new int[]{0, 0, 1, 1, 0}));
    }

    private static int findLongestContinuosArray(int[] intArray) {
        int longestCount = 0;
        int len = intArray.length;
        int countOfZero =0, countOfOne = 0;
        int previousCount = 0;
        int indexCount =0;
        for (int i=0; i<len; i++) {
            indexCount ++;
            if (intArray[i]==0) {
                countOfZero++;
            }
            if (intArray[i]==1) {
                countOfOne++;
            }
            for (int j=i+1; j < len; j++) {
                indexCount ++;
                if (intArray[j]==0) {
                    countOfZero++;
                }
                if (intArray[j]==1) {
                    countOfOne++;
                }
               // System.out.println("Index Count>>>" + indexCount  + " Count of Zero >>> " + countOfZero + " Count of One >>> " + countOfOne );
                if (indexCount %2 ==0 && countOfZero == countOfOne) {
                    longestCount = (countOfOne + countOfZero);
                }
            }
            //System.out.println("Longest Count Found between i" + i + " and j " + (len-1) + " == " + longestCount);
            countOfZero =0;
            countOfOne = 0;
            if (longestCount > previousCount) previousCount = longestCount;
            longestCount = 0;
            indexCount = 0;
        }
        return previousCount;
    }

    private static int findLongestSubCount(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        for (int i=0; i< arr.length; i++) {
            sum += arr[i] ==0 ? -1 : 1;
            if (sum==0) {
                res = i + 1;
            }
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}

