package leetcode.arrays.easy;

/**
 *
 * Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. I
 * if the array is sorted then return True, Else return False.
 */
public class CheckIfGivenArraySorted {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println("Is Given Array Sorted == " + isArraySorted(arr));
        arr = new int[] {5,4,6,7,8};
        System.out.println("Is Given Array Sorted == " + isArraySorted(arr));
    }

    private static boolean isArraySorted(int[] arr) {
        boolean result = false;
        int n = arr.length;
        for (int i=1; i<n; i++) {
            if (!(arr[i-1] < arr[i])) {
                return false;
            } else {
                result = true;
            }
        }
        return result;
    }
}
