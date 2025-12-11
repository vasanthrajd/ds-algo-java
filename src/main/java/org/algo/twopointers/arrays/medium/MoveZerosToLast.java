package org.algo.twopointers.arrays.medium;

import java.util.Arrays;

public class MoveZerosToLast {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 0, 2, 0, 6, 0, 2, 3};
        System.out.println(Arrays.toString(moveZerosToLastWithCounter(nums)));
        nums = new int[]{0, 0, 1, 0, 2, 0, 6, 0, 2, 0};
        System.out.println(Arrays.toString(moveZerosToLastWithCounter(nums)));
    }

    private static int[] moveZeroToLast(int[] nums) {
        int len = nums.length;
        for (int i = 0, j = len - 1; i < len; ) {
            if (nums[i] == 0) {
                if (nums[j] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j--;
                } else {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            } else {
                i++;
            }
        }
        return nums;
    }

    private static int[] moveZerosToLastWithCounter(int[] nums) {
        int[] returnNum = new int[nums.length];
        int counter = 0;
        int j=returnNum.length-1;
        for (int num : nums) {
            if (num != 0) {
                returnNum[counter] = num;
                counter++;
            } else {
                returnNum[j]=0;
                j--;
            }
        }
        /*while (counter < returnNum.length) {
            returnNum[counter]=0;
            counter++;
        }*/
        return returnNum;
    }
}
