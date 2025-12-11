package leetcode.arrays;

import java.util.Arrays;

public class ReverseArrayInPlace {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9, 8, 6,4,2,0};
        int[] revArr = reverseArrayInPlace(arr);
        for (int i : revArr) {
            System.out.print(i + "\t");
        }
    }

    private static int[] reverseArrayInPlace(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
        return arr;
    }

}
