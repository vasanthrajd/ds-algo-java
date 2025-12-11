package leetcode.arrays;

import java.util.Arrays;

public class CheckDuplicatesInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,6,7,1,3,4,6,9, 8};
        bruteForceApproach(arr);
        sortAndCheck(arr);
    }

    private static void sortAndCheck(int[] arr) {
        Arrays.sort(arr);
        boolean haveDuplicate = false;
        for (int i=0; i< arr.length ; i++) {
            if (arr[i] == arr[i+1]) {
                haveDuplicate = true;
                break;
            }
        }
        System.out.println("Given Array have duplicates (Sort and Adjacent Compare) = " + haveDuplicate);
    }

    /**
     * Works without Sorting the array
     * @param arr: input Array
     */
    private static void bruteForceApproach(int[] arr) {
        int i = 0;
        int len = arr.length;
        boolean haveDuplicate = false;
        for (; i<len ; i++ ) {
            for (int j= i+1; j<len; j++) {
                if (arr[i]==arr[j]) {
                    haveDuplicate = true;
                    break;
                }
            }
        }
        System.out.println("Given Array have duplicates (Brute Force) = " + haveDuplicate);
    }

}
