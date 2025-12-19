package leetcode.arrays.hard;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge both the arrays into a single array sorted in non-decreasing order.
 * The final sorted array should be stored inside the array nums1 and it should be done in-place.
 *
 * Array nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s
 * whereas nums2 has a length of n.
 *
 *
 * Input : nums1 = [-5, -2, 4, 5, 0, 0, 0], nums2 = [-3, 1, 8]
 * Output : [-5, -3, -2, 1, 4, 5, 8]
 * Explanation : The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4, 5] are from nums1 and [-3, 1, 8] are from nums2
 *
 *
 * Input : nums1 = [0, 2, 7, 8, 0, 0, 0], nums2 = [-7, -3, -1]
 * Output :  [-7, -3, -1, 0, 2, 7, 8]
 * Explanation :  The merged array is: [-7, -3, -1, 0, 2, 7, 8], where [0, 2, 7, 8] are from nums1 and [-7, -3, -1] are from nums2
 *
 *
 */
public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] numArray1 = new int[] {-5, -2, 4, 5, 0, 0, 0};
        int[] numArray2 = new int[] {-3, 1, 8};

        //int[] mergedArray = easyMergeArrays(numArray1, numArray2);
        int[] mergedArray =pointerBasedInPlaceSorting(numArray1, numArray2);
        System.out.println("Merged Array is " + Arrays.toString(mergedArray));

         numArray1 = new int[] {0, 2, 7, 8, 0, 0, 0};
         numArray2 = new int[] {-7, -3, -1};

        //mergedArray = easyMergeArrays(numArray1, numArray2);
        mergedArray = pointerBasedInPlaceSorting(numArray1, numArray2);
        System.out.println("Merged Array is " + Arrays.toString(mergedArray));

    }

    private static int[] easyMergeArrays(int[] numArray1, int[] numArray2) {

        int swapIndex = Math.abs(numArray1.length - numArray2.length);

        for (int j : numArray2) {
            numArray1[swapIndex] = j;
            swapIndex++;
        }
        Arrays.sort(numArray1);
        return numArray1;
    }


    private static int[] pointerBasedInPlaceSorting(int[] numArray1, int[] numArray2) {
        int zeroStartIndex = Math.abs(numArray1.length - numArray2.length)-1;
        int compareIndex = numArray2.length-1;
        int shiftIndex = numArray1.length-1;
        while(compareIndex >=0 ) {
            if (numArray1[zeroStartIndex] > numArray2[compareIndex] && zeroStartIndex !=0) {
                int temp = numArray1[zeroStartIndex];
                numArray1[zeroStartIndex] = numArray1[shiftIndex];
                numArray1[shiftIndex] = temp;
                shiftIndex--;
                zeroStartIndex--;
            } else if (zeroStartIndex ==0 ) {
                int temp = numArray1[zeroStartIndex];
                numArray1[zeroStartIndex] =numArray2[compareIndex];
                numArray1[shiftIndex] = temp;
                shiftIndex--;
                compareIndex--;
            } else {
                numArray1[shiftIndex] = numArray2[compareIndex];
                compareIndex--;
                shiftIndex--;
            }
        }
        return numArray1;
    }
}
