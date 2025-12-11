package leetcode.arrays.easy;

/*
Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.
Example 1:
Input Format: arr[] = {2,2,1}
Result: 1
Explanation: In this array, only the element 1 appear once and so it is the answer.
 */
public class FindANumberAppearOnceAndOthersTwice {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println("Occured once in the given array " + getSingleElement(arr));
    }

    public static int getSingleElement(int[] arr) {
        int xorr = 0;

        // XOR all elements — duplicates cancel each other out
        for (int num : arr) {
            System.out.print("Xor of " + xorr + " with other num is " + num );
            xorr ^= num;
            System.out.println(" result is " + xorr);
        }

        return xorr;
    }
}
