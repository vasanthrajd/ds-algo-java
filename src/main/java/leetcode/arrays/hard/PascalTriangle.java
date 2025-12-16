package leetcode.arrays.hard;

import java.util.Arrays;

/**
 * Write a program to generate Pascal's triangle.
 * In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:
 * Input: N = 5, r = 5, c = 3
 * Output: Element at position (r, c): 6
 * N-th row of Pascal’s triangle: 1 4 6 4 1
 * First n rows of Pascal’s triangle:
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * Explanation: Pascal triangle for first 5 rows is shown above.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int n =5;
        int row = 5;
        int column = 6;
        int[][] matrix = new int[n][n];
        fillAndFindValueForRowAndColumnInPascalTriangle(matrix, row, column, n);
    }

    private static void fillAndFindValueForRowAndColumnInPascalTriangle(int[][] matrix, int row, int column, int n) {
        int rowNumber = matrix.length;
        int columnNumber = matrix[0].length;
        for (int i=0; i<rowNumber; i++) {
            int numbersToBeFilledInCurrentRow = i+1;
            boolean isEven = (numbersToBeFilledInCurrentRow % 2 == 0);
            int left = 0;
            int right = columnNumber;
            for (int j=0; j<columnNumber; j++) {
                if (numbersToBeFilledInCurrentRow == 1) {
                    if (n/2 == j) {
                        matrix[i][j] =1;
                    }
                } else {
                    fillRowWithValuesUsingNandIndex(matrix, numbersToBeFilledInCurrentRow, i, j, columnNumber);
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));

    }

    private static void fillRowWithValuesUsingNandIndex(int[][] matrix, int numbersToBeFilledInCurrentRow, int i, int j, int columnNumber) {
        if (j==0 || j == columnNumber-1) {
            matrix[i][j] = 1;
            numbersToBeFilledInCurrentRow--;
        } else {
            int value = matrix[i-1][j-1] + matrix[i-1][j+1];
            matrix[i][j] = value;
            numbersToBeFilledInCurrentRow--;
        }
    }
}
