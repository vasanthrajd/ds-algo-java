package leetcode.arrays;

import java.util.Arrays;

public class FindPair {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5,6,7,2,4,5};
        int pairCount = findNoOfPairs(nums);
        System.out.println("Number of pairs in the given array " + Arrays.toString(nums) + " pair count " + pairCount);
    }

    private static int findNoOfPairs(int[] nums) {
        Arrays.sort(nums);
        int pairCount= 0;
        int isCompared = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1] && isCompared == 0) {
                pairCount++;
                isCompared =1;
            } else {
                isCompared =0;
            }
        }
        return pairCount;
    }
}
