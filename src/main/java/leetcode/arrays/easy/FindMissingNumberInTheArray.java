package leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given Nums array with 'N' Numbers, in which find the number which are missing in it
 *
 * For example: int[] nums = new int[] {7,9,8,3,1,5,5,3} where n is 10
 */
public class FindMissingNumberInTheArray {
    public static void main(String[] args) {
        int[] nums = new int[] {7,8,3,1,5,5,3};
        int[] missingNumber = findMissingNumberInTheGivenArray(nums, 8);
        System.out.println("Missing Number in the Given Array is " + Arrays.toString(missingNumber));
    }

    private static int[] findMissingNumberInTheGivenArray(int[] nums, int n) {
        int len = nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int previous = nums[0];
        for (int i=1; i<len; i++) {
            if (previous == nums[i]) {
                previous = nums[i];
                continue;
            } else if (previous+1 != nums[i]) {
                list.add(previous+1);
            }
            previous = nums[i];
        }
        return list.stream().mapToInt(value -> value)
                .toArray();
    }

}
