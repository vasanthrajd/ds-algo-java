package leetcode.binarysearch;

/**
 * You are given a sorted array of integers and a target, your task is to search for the target in the given array.
 * Assume the given array does not contain any duplicate numbers.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 5, 6, 7, 8, 9, 10, 12, 23, 53, 57, 90};
        System.out.println(findElementUsingRecursionBinary(arr, 23));
        System.out.println(findElementUsingWhileLoop(arr, 23));
    }

    private static int findElementUsingRecursionBinary(int[] arr, int i) {
        int index = recursionBinarySearch(arr, i, 0, arr.length-1);
        if (index == -1) {
            System.out.println("Element Not Found in the Array and result is negative >>" + -1);
            return 0;
        }
        System.out.println("Element Found in the Array and it is " + arr[index]);
        return arr[index];
    }

    private static int findElementUsingWhileLoop(int[] arr, int i) {
        int index = binarySearchUsingWhile(arr, i);
        if (index == -1) {
            System.out.println("Element Not Found in the Array and result is negative >> " + -1);
            return 0;
        }
        System.out.println("Element Found in the Array and it is " + arr[index]);
        return arr[index];
    }



    private static int recursionBinarySearch(int[] arr, int element, int left, int right) {
        int mid = (left + right)/2;
        if (arr[mid] == element) {
            return mid;
        } else if (element > arr[mid]) {
            left = mid + 1;
        } else if (element < arr[mid]){
            right = mid - 1;
        }
        if (left > right) {
            return -1;
        }
        return recursionBinarySearch(arr, element, left, right);
    }

    private static int binarySearchUsingWhile(int[] arr, int element) {
        int left = 0;
        int right = arr.length-1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (arr[mid] == element) {
                index = mid;
                break;
            } else {
                if (element > arr[mid]) {
                    left = mid + 1;
                } else if (element < arr[mid]){
                    right = mid - 1;
                }
            }
        }
        return index;
    }
}

