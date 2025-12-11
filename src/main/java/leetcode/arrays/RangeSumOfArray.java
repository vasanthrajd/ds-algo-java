package leetcode.arrays;

/**
 * Given an integer array nums, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 * <p>
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= left <= right < nums.length
 * At most 104 calls will be made to sumRange.
 */

public class RangeSumOfArray {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, -2, 5, 69, -87, 24, 1});
        System.out.println(numArray.sumRange(0, 4));
        System.out.println(numArray.sumRange(2, 6));
        System.out.println(numArray.sumRange(2, 90));

    }
}

class NumArray {
    int[] arr;

    public NumArray(int[] arr) {
        this.arr = arr;
    }

    public int sumRange(int i, int j) {
        int len = this.arr.length;
        if (len < i || len < j) {
            return -1;
        }
        int sum = 0;
        if (i > j) {
            return -1;
        }
        while (i<=j && i<len) {
            sum += this.arr[i];
            i++;
        }
        return sum;
    }
}
