package leetcode.recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,50, 90, 100};
        int[] newArr = new int[arr.length];
        reverseArray(arr, newArr, arr.length, 0);
        System.out.println(Arrays.toString(newArr));
    }

    private static void reverseArray(int[] arr, int[] newArr, int length, int index) {
        if (index == arr.length) {
            return;
        }
        newArr[index] = arr[length-1];
        index +=1;
        length -=1;
        reverseArray(arr, newArr, length, index);
    }

}
