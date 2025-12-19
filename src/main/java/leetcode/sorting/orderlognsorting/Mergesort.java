package leetcode.sorting.orderlognsorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of size n, sort the array using Merge Sort.
 */
public class Mergesort {
    public static void main(String[] args) {
        int[] arr = new int[] {28, 14, 3, 25};
        mergeSortTheGivenArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortTheGivenArray(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        System.out.println("Between the Index >> " + low + " --- " + high + "== " + Arrays.toString(Arrays.copyOfRange(arr, low, high+1)));
        if (low >= high) {
            return;
        }
        // Find mid index
        int mid = (low + high) / 2;
        // Sort left half
        mergeSort(arr, low, mid);
        System.out.println("After Left Half of Array >> " + low + " --- " + high + "== " + Arrays.toString(Arrays.copyOfRange(arr, low, high+1)));
        // Sort right half
        mergeSort(arr, mid + 1, high);
        // Merge both halves
        merge(arr, low, mid, high);
    }
    public static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        // Merge both sorted parts
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }
        // Add remaining left elements
        while (left <= mid)
            temp.add(arr[left++]);
        // Add remaining right elements
        while (right <= high)
            temp.add(arr[right++]);
        // Copy back to original array
        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);
    }
}
