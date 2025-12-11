package leetcode.arrays.easy;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the left by one.
 *
 * Note: There is no need to return anything, just modify the given array.
 *
 * Input: nums = [1, 2, 3, 4, 5]
 * Output: [2, 3, 4, 5, 1]
 * Explanation: Initially, nums = [1, 2, 3, 4, 5]
 * Rotating once to the left results in nums = [2, 3, 4, 5, 1].
 *
 * Input: nums = [-1, 0, 3, 6]
 * Output: [0, 3, 6, -1]
 * Explanation: Initially, nums = [-1, 0, 3, 6]
 * Rotating once to the left results in nums = [0, 3, 6, -1].
 */
public class RotateArrayByDirectionAndByNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,2,2,3,3};
        int rotatePosition = 1;
        rotateArrayByDirectionAndNumber("LEFT", arr, rotatePosition);
        arr = new int[] {1, 2, 3, 4, 5};
        rotateArrayByDirectionAndNumber("LEFT", arr, rotatePosition);
        arr = new int[] {-1, 0, 3, 6};
        rotateArrayByDirectionAndNumber("LEFT", arr, rotatePosition);
    }

    private static void rotateArrayByDirectionAndNumber(String left, int[] arr, int rotatePosition) {
        if (left.equals("LEFT")) {
          int len = arr.length;
            reverseArray(arr, 0, rotatePosition-1);
            reverseArray(arr, rotatePosition, len-1);
            reverseArray(arr, 0, len-1);



            System.out.println(Arrays.toString(arr));
        }
    }

    private static void rotateArrayToLeft(int[] arr, int rotatePosition) {
        int length = arr.length;
        int left = 0;
        int right = arr.length -1;
        int k = rotatePosition % length;

        for (int i=0; i < k; i++) {


            int temp = arr[i];
            int intermediateIndex  = i + k;
            if (intermediateIndex>= length) {
                intermediateIndex = length - i;
            }
            arr[i] = arr[intermediateIndex];
            arr[intermediateIndex] = temp;

        }
        System.out.println(Arrays.toString(arr));

    }

    private static void reverseArray(int[] arr, int startPosition, int endPosition) {
        while (startPosition < endPosition) {
            int temp = arr[startPosition];
            arr[startPosition] = arr[endPosition];
            arr[endPosition] = temp;
            startPosition ++;
            endPosition --;
        }
    }
}

