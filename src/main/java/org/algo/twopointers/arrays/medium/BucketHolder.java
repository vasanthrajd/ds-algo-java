package org.algo.twopointers.arrays.medium;

//# Example: height = [1,8,6,2,5,4,8,3,7]
//# Output: 49 (between indices 1 and 8)
// Find two lines that form a container holding the most water.

import java.util.Arrays;

/**
 * Problem Statement:
 * You are given an array height where each element represents the height of a vertical line at that index.
 * Your task is to find two lines (indices) that, together with the x-axis,
 * form a container that can hold the most water.
 * Key Points to Understand: *
 * 1) Container Formation: The two selected lines act as the left and right boundaries of the container.
 * 2) Water Capacity: The amount of water a container can hold is determined by: *
 * Width: Distance between the two lines (right_index - left_index).
 * Height: The shorter of the two lines (min(height[left], height[right])).
 * Total Water = Width × Height.
 * Example:
 * Given height = [1, 8, 6, 2, 5, 4, 8, 3, 7], the optimal container is between
 * indices 1 (height 8) and 8 (height 7).
 * Width = 8 - 1 = 7
 * Height = min(8, 7) = 7
 * Max Water = 7 * 7 = 49
 * Why Two-Pointer Approach Works Here? *
 * The array is traversed from both ends (left and right pointers). *
 * At each step, the pointer pointing to the shorter line moves inward
 * (since increasing width is not helpful if height is limiting).
 * This efficiently narrows down the solution in O(n) time.
 */
public class BucketHolder {
    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum Water that container can hold is "+ findMaxContainerSize(arr));
        arr = new int[] {10, 45, 2, 5, 54};
        System.out.println("Maximum Water that container can hold is "+ findMaxContainerSize(arr));
    }

    private static String findMaxContainerSize(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len-1;
        int maxSize = 0;
        int[] index = {0,0};
        while (left < right) {
            int widthOfContainer = right - left;
            int height = Math.min(arr[left], arr[right]);
            int containerSize = widthOfContainer * height;
            System.out.println("Container Size "+ containerSize + " between index is (" + left + ", "+ right + ")");
            if (maxSize < containerSize) {
                maxSize = containerSize;
                index = new int[]{left, right};
            }
            if (arr[left]> arr[right]) {
                right --;
            } else {
                left ++;
            }
        }
        return String.format("Maximum Water can be filled if we have container from the point %s " +
                "and amount of water it can " +
                "hold is %d", Arrays.toString(index), maxSize);

    }
}
