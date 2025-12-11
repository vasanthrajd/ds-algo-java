package leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array arr[] of size n, the task is to find all the Leaders in the array.
 * An element is a Leader if it is greater than or equal to all the elements to its right side.
 *
 *
 * Input: arr[] = [16, 17, 4, 3, 5, 2]
 * Output: [17 5 2]
 * Explanation: 17 is greater than all the elements to its right i.e., [4, 3, 5, 2],
 * therefore 17 is a leader. 5 is greater than all the elements to its right i.e.,
 * [2], therefore 5 is a leader. 2 has no element to its right, therefore 2 is a leader.
 *
 * Input: arr[] = [1, 2, 3, 4, 5, 2]
 * Output: [5 2]
 * Explanation: 5 is greater than all the elements to its right i.e., [2], therefore 5 is a leader.
 * 2 has no element to its right, therefore 2 is a leader.
 */
public class LeadersInAArray {
    public static void main(String[] args) {
        int[] nums = new int[] {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders in the Array " + Arrays.toString(optimalApproach(nums)));
        nums = new int[] {1, 2, 3, 4, 5, 2};
        System.out.println("Leaders in the Array " + Arrays.toString(optimalApproach(nums)));
        nums = new int[] {1, 2, 3, 4, 5, 2};
        System.out.println("Leaders in the Array " + Arrays.toString(optimalApproach(nums)));
        nums = new int[] {4, 7, 1, 0};
        System.out.println("Leaders in the Array " + Arrays.toString(optimalApproach(nums)));
        nums = new int[] {10, 22, 12, 3, 0, 6};
        System.out.println("Leaders in the Array " + Arrays.toString(optimalApproach(nums)));

    }

    private static int[] leadersInGivenArray(int[] nums) {
        int[] result = new int[nums.length];
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int index =0;
        while (left < len) {
            boolean leftMax = true;
            for (int i=left +1; i <= right; i++) {
                if (!(nums[left] > nums[i])) {
                    leftMax = false;
                    break;
                }
            }
            if (leftMax || left==len-1) {
                result[index] = nums[left];
                index ++;
            }
            left++;
        }
        return result;
    }

    public static int[] optimalApproach(int[] nums) {
        List<Integer> integerList = new ArrayList<>();
        int left = 0;

        int max = nums[nums.length-1];
        integerList.add(max);
        int right = nums.length-2;
        while (right >=0) {
            if(nums[right] > max) {
                integerList.add(nums[right]);
                max = nums[right];
            } else {
                right--;
            }
        }
        Collections.reverse(integerList);
        return integerList.stream().mapToInt(value -> value.intValue()).toArray();
    }
}
