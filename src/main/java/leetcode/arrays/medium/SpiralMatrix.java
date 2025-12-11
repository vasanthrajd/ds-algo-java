package leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a Matrix, print the given matrix in spiral order.
 *
 * Examples:
 *
 * Input: Matrix[][] = { { 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 } }
 * Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
 * Explanation: The output of matrix in spiral form.
 *
 * Input: Matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 },{ 7, 8, 9 } }
 * Output: 1, 2, 3, 6, 9, 8, 7, 4, 5.
 * Explanation: The output of matrix in spiral form.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16}
        };

       // spiralOrder(matrix);
        printSpiralMatrix(matrix);
    }

    private static void printSpiralMatrix(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        int [] result = new int[(matrix.length * matrix[0].length)] ;
        int index =0;
        while (top < bottom & left < right) {
            for (int i=left; i<right; i++ ) {
                result[index] = matrix[top][i];
                index++;
            }
            top++;
            for (int i = top; i < bottom; i++) {
                result[index] = matrix[i][right-1];
                index++;
            }
            right--;
            for (int i=bottom-2; i >=0; i--) {
                result[index] = matrix[bottom-1][i];
                index++;
            }
            for (int i=bottom-2; i>=top; i-- ) {
                result[index] = matrix[i][left];
                index++;
            }
            left++;
            right--;
        }
        System.out.println(Arrays.toString(result));
    }

    public static List spiralOrder(int[][] matrix) {
        // Result list to store the spiral order
        List result = new ArrayList<>();

        // Initialize boundaries
        int top = 0;                        // Starting row
        int bottom = matrix.length - 1;     // Ending row
        int left = 0;                       // Starting column
        int right = matrix[0].length - 1;   // Ending column

        // Loop until all elements are traversed
        while (top <= bottom && left <= right) {

            // Traverse the top row from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary downward

            // Traverse the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftward

            // Traverse the bottom row from right to left (only if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top (only if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }
        System.out.println(result);
        // Return the spiral order result
        return result;
    }
}
