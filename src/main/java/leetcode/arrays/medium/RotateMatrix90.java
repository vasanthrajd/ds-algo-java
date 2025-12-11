package leetcode.arrays.medium;

import java.util.Arrays;

/**
 * Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
 * The rotation must be done in place, meaning the input 2D matrix must be modified directly
 */
public class RotateMatrix90 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        //System.out.println("Rotate The Matrix 90' degree >>"+ Arrays.deepToString(rotateMatrix(matrix)));
        optimalSolution(matrix);
        System.out.println("Rotate The Matrix 90' degree >>"+ Arrays.deepToString(matrix));

    }

    private static int [][] rotateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] resultMatrix = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int value = matrix[i][j];
                resultMatrix[j][m-i-1]=value;
            }
        }
        return resultMatrix;
    }

    private static void optimalSolution(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int temp = matrix[j][i];
                matrix[j][i]  = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for (int i=0; i <m ; i++) {
            int left = i;
            while ( left < n) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[n-1][i];
                matrix[n-1][i] = temp;
                left++;
                n--;
            }
        }
    }

}

