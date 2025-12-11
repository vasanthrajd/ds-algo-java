package leetcode.arrays.medium;

import java.util.Arrays;

/**
 * Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0
 * and then return the matrix..
 * Input: matrix=[
 *  [1,1,1],
 *  [1,0,1],
 *  [1,1,1]
 *  ]
 * Output: [
 *      [1,0,1],
 *      [0,0,0],
 *      [1,0,1]]
 * Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
 *
 * Input: matrix=[
 *  [0,1,2,0],
 *  [3,4,5,2],
 *  [1,3,1,5]
 *  ]
 * Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
 */
public class SetMatrixToZero {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1},
        };

        System.out.println("Update Matrix's row and column if any of the index is 0 \t " + Arrays.deepToString(updateMatrixRowAndColumnToZero(matrix)));


        matrix = new int[][] {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5},
        };

        System.out.println("Update Matrix's row and column if any of the index is 0\t " + Arrays.deepToString(updateMatrixRowAndColumnToZero(matrix)));
    }

    private static int[][] updateMatrixRowAndColumnToZero(int[][] matrix) {
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        boolean[] rowZero = new boolean[rowLen];
        boolean[] columnZero = new boolean[columnLen];
        for (int i=0; i< rowLen; i++) {
            for (int j=0; j<columnLen; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    columnZero[j] = true;
                }
            }
        }
        for (int i=0; i<rowLen; i++) {
            for (int j=0; j<columnLen; j++) {
                if (rowZero[i] || columnZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

}
