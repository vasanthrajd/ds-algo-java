package leetcode.slinding_window_2_pointers.medium;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Input : nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] , k = 3
 * Output : 10
 * Explanation : The maximum number of consecutive 1's are obtained only if we flip the 0's present at position 3, 4, 5 (0 base indexing).
 * The array after flipping becomes [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0].
 * The number of consecutive 1's is 10.
 *
 *
 * Input : nums = [0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1] , k = 3
 * Output : 9
 * Explanation : The underlines 1's are obtained by flipping 0's in the new array.
 * [1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1].
 * The number of consecutive 1's is 9.
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 3;
        System.out.println("Maximum Consecutive 1's can be formed from the given array is " + maxConsecutiveOne(arr, k));
         arr = new int[] {0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1};
         k = 3;
        System.out.println("Maximum Consecutive 1's can be formed from the given array is " + maxConsecutiveOne(arr, k));
        k = 2;
        System.out.println("Maximum Consecutive 1's can be formed from the given array is " + maxConsecutiveOne(arr, k));
        k = 1;
        System.out.println("Maximum Consecutive 1's can be formed from the given array is " + maxConsecutiveOne(arr, k));

    }
    private static int maxConsecutiveOne(int[] arr, int k) {
        int max = 0;
        int len = arr.length;
        int left = 0;
        int right = 0;
        int flipCount = k;
        int count =0;
        while (right < len) {
            int value = arr[right];
            if (value == 1) {
                count +=1;
            } else if (value == 0 && flipCount !=0) {
                count +=1;
                flipCount--;
            } else if (value ==0) {
                left = right;
                flipCount = k;
                count=0;
            }
            max = Math.max(max, count);
            right ++;
        }
        return max;
    }

}
