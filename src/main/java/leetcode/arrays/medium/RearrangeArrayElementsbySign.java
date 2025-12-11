package leetcode.arrays.medium;

import java.util.*;

/**
 * There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements.
 * Without altering the relative order of positive and negative elements,
 * you must return an array of alternately positive and negative values.
 *
 * Example 1:
 * Input:
 * arr[] = {1,2,-4,-5}, N = 4
 * Output:
 * 1 -4 2 -5
 * Explanation:
 * Positive elements = 1,2
 * Negative elements = -4,-5
 * To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.
 *
 *
 * Example 2:
 * Input:
 * arr[] = {1,2,-3,-1,-2,-3}, N = 6
 * Output:
 * 1 -3 2 -1 3 -2
 * Explanation:
 * Positive elements = 1,2,3
 * Negative elements = -3,-1,-2
 * To maintain relative ordering, 1 must occur before 2, and 2 must occur before 3.
 * Also, -3 should come before -1, and -1 should come before -2.
 */
public class RearrangeArrayElementsbySign {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,-4,-5};
        rearrangeArrayInRelativeOrder(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[] {1,2,-3,-1,-2,-3};
        rearrangeArrayInRelativeOrder(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrangeArrayInRelativeOrder(int[] arr) {
        int len = arr.length;
        List<Integer> positiveSet = new ArrayList<>();
        List<Integer> negativeSet = new ArrayList<>();
        for (int j : arr) {
            if (j > 0) {
                positiveSet.add(j);
            } else {
                negativeSet.add(j);
            }
        }
        Collections.sort(positiveSet);
        Collections.sort(negativeSet);
        System.out.println(positiveSet.toString());
        System.out.println(negativeSet.toString());
        int minLen = Math.min(positiveSet.size(), negativeSet.size());
        int arrayIndex = 0;
        for (int i=0; i< minLen; i++ ) {
            int postI = positiveSet.get(i);
            int negtI =  negativeSet.get(i);
            arr[arrayIndex] = postI;
            arrayIndex++;
            arr[arrayIndex] = negtI;
            arrayIndex++;
        }
        int maxLen = Math.max(positiveSet.size(), negativeSet.size());
        while (minLen < maxLen) {
            arr[arrayIndex] = positiveSet.size() > negativeSet.size() ? positiveSet.get(minLen) : negativeSet.get(minLen);
            minLen++;
            arrayIndex++;
        }
    }
}
