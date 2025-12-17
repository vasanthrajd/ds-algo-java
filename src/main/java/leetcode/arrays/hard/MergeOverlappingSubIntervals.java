package leetcode.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Input : intervals=[[1,3],[2,6],[8,10],[15,18]]
 * Output : [[1,6],[8,10],[15,18]]
 * Explanation : Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6] intervals.
 * <p>
 * <p>
 * Input : [[1,4],[4,5]]
 * Output :  [[1,5]]
 * Explanation :  Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
 */
public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        mergeOverLappingIntervals(array);
        mergeOverlappingInEfficientWay(array);
        array = new int[][]{
                {1, 4},
                {4, 5}
        };
        mergeOverLappingIntervals(array);
        mergeOverlappingInEfficientWay(array);
        array = new int[][]{
                {1, 2},
                {2, 3},
                {5, 6},
                {6, 7},
                {8, 10},
                {11, 12},
        };
        mergeOverLappingIntervals(array);
        mergeOverlappingInEfficientWay(array);
        array = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {5,6},
                {6, 7}
        };
        mergeOverLappingIntervals(array);
        mergeOverlappingInEfficientWay(array);
    }

    /**
     * Elements weren't sorted when processing.
     * @param array
     */
    private static void mergeOverLappingIntervals(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int[][] mergedArray = new int[row][col];
        int[] currentArr = new int[col];
        int[] prevArr = array[0];
        int mergedRowCount = 0;
        boolean canWeIncludeLastArray = false;
        for (int i = 0; i < row; i++) {
            if (prevArr[1] < array[i][0]) {
                mergedArray[mergedRowCount] = prevArr;
                prevArr = array[i];
                mergedRowCount++;
            } else {
                prevArr[1] = array[i][1];
            }
            if (i == row - 1) {
                canWeIncludeLastArray = true;
            }
        }
        if (canWeIncludeLastArray) {
            mergedArray[mergedRowCount] = prevArr;
        }
        System.out.println(Arrays.deepToString(mergedArray));
    }

    private static void mergeOverlappingInEfficientWay(int[][] array) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array, (a, b) -> a[0]-b[0]);

        for (int i=0; i < array.length ; i++) {
            if (result.isEmpty() || result.get(result.size()-1).get(1) < array[i][0]) {
                result.add(Arrays.asList(array[i][0], array[i][1]));
            } else {
                int size = result.size()-1;
                int maxEnd = Math.max(result.get(size).get(1), array[i][1]);
                result.get(size).set(1, maxEnd);
            }
        }


        for (List<Integer> interval : result) {
            System.out.print(
                    "[" + interval.get(0) + "," + interval.get(1) + "] "
            );
        }
    }
}
