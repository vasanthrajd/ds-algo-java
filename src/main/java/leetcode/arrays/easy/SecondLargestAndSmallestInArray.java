package leetcode.arrays.easy;

import java.util.Arrays;

/**
 * Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
 * Example 1:
 * Input: [1, 2, 4, 7, 7, 5]
 * Output:
 * Second Smallest : 2
 * Second Largest : 5
 */
public class SecondLargestAndSmallestInArray {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 4, 7, 7, 5};
      //  Arrays.sort(array);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMax = max;
        int secondMin = min;
        int n = array.length;
        for (int i=0; i<n ; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            } else if (array[i] > secondMax) {
                secondMax = array[i];
            }
            if (array[i] < min) {
                secondMin = min;
                min = array[i];
            } else if (array[i] < secondMin){
                secondMin = array[i];
            }

        }

       /* for (int i=0; i<n ; i++) {
            if (array[i]==max || array[i]==min) {
                continue;
            }
            if (array[i] > secondMax) {
                secondMax = array[i];
            }
            if (array[i] < secondMin) {
                secondMin = array[i];
            }
        }*/
        System.out.println("Second Smallest in the given array is " + secondMin);
        System.out.println("Second Biggest in the given array is " + secondMax);
    }
}
