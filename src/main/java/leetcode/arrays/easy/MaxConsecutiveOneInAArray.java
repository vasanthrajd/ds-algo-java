package leetcode.arrays.easy;

/**
 * Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array..
 * Example 1:
 * Input: prices = {1, 1, 0, 1, 1, 1}
 * Output: 3
 * Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.
 */
public class MaxConsecutiveOneInAArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 0, 1, 1, 1};
        System.out.println("Maximum Consecutive One's in the Given Array is " + maxConsecutiveOneInAArray(arr));
    }

    private static int maxConsecutiveOneInAArray(int[] arr) {
        int result = 0;
        int currentStreak =0;
        int len = arr.length;
        for (int i=1; i< len; i++) {
            if (arr[i] == 1) {
                currentStreak++;
            } else {
                // If element is 0, reset count
                currentStreak = 0;
            }

            // Update maximum if current count is greater
            result = Math.max(result, currentStreak);
        }
        return result;
    }
}
