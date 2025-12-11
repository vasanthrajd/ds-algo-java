package org.algo.twopointers.arrays.medium;

/**
 * Problem Statement:
 * Given an integer array height representing elevations of bars, compute
 * how much water can be trapped between the bars after raining.
 * Container With Most Water
 * Key Requirements:
 * Given an array arr[] of non-negative integers, where each element arr[i] represents the
 * height of vertical lines, determine the maximum amount of water that can be contained
 * between any two lines, along with the x-axis.
 *
 * Note: In the case of a single vertical line, it will not be able to hold water.
 * Example:
 * Input: arr[] = [1, 5, 4, 3]
 * 6
 * Explanation:
 * The vertical lines at heights 5 and 3 are 2 distance apart. The base size is 2. The height of the container is the minimum of these two values, min(5, 3) = 3.
 * So, the total area to hold water is 3 * 2 = 6.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total Water that can trapped in this given height is " +trapWaterBetweenBar(height));

        height = new int[]{1, 5, 4, 3};
        System.out.println("Total Water that can trapped in this given height is " +trapWaterBetweenBar(height));

        height = new int[]{3, 1, 2, 4, 5};
        System.out.println("Total Water that can trapped in this given height is " +trapWaterBetweenBar(height));

        height = new int[]{2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println("Total Water that can trapped in this given height is " +trapWaterBetweenBar(height));
    }

    private static int trapWaterBetweenBar(int[] height) {
        int left=0;
        int len = height.length;
        int water = 0;
        int left_max = 0;
        int right_max = 0;
        for (int i=0, j= len-1; i< j; ) {
            left_max = Math.max(left_max, height[i]);
            right_max = Math.max(right_max, height[j]);
            int distance = j -i;
            int containerSize = distance *  Math.min(left_max, right_max);
           // System.out.println("Distance Between I and J is " + i + " " + j + " == " + distance );
           // System.out.println("Left max and right max " + left_max + " " + right_max);
           // System.out.println("Container Size it can hold is " + containerSize );
            if (water < containerSize) {
                water = containerSize;
            //    System.out.println("Max Water Over Ride is "+ water);
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return water;
    }
}
