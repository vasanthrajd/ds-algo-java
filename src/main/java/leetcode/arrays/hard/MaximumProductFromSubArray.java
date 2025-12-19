package leetcode.arrays.hard;

/**
 * Given an array that contains both negative and positive integers, find the maximum product subarray.
 *
 * Input: Nums = [1,2,3,4,5,0]
 * Output: 120
 * Explanation:
 * In the given array, 1×2×3×4×5 gives maximum product value.
 *
 * Input: Nums = [1,2,-3,0,-4,-5]
 * Output: 20
 * Explanation:
 * In the given array, (-4)×(-5) gives maximum product value.
 */
public class MaximumProductFromSubArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,0};
        System.out.println("Maximum Product From Sub Array >> " + findMaximumProductFromSubArray(arr));
        arr = new int[] {1,2,-3,0,-4,-5};
        System.out.println("Maximum Product From Sub Array >> " + findMaximumProductFromSubArray(arr));
    }

    private static int findMaximumProductFromSubArray(int[] arr) {
        int product = 1;
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            product *= arr[i];
            if (product == 0) {
                product =1;
            }
            maxValue = Math.max(maxValue, product);
        }
        return maxValue;
    }
}
