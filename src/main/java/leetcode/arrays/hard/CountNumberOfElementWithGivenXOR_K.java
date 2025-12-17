package leetcode.arrays.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers A and an integer B
 * Find the total number of subarrays having bitwise XOR of all elements equal to k.
 *
 * Input: A = [4, 2, 2, 6, 4] , k = 6
 * Output: 4
 * Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
 *
 * Input: A = [5, 6, 7, 8, 9], k = 5
 * Output: 2
 * Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
 */
public class CountNumberOfElementWithGivenXOR_K {
    public static void main(String[] args) {
        int[] arr  = new int[] {4, 2, 2, 6, 4};
        int k = 6;
       // countNumberOFElementWithGivenXOR(arr, k);
        optimalWayToFindCountNumberOfElementWithGivenXOR(arr, k);
       /* arr = new int[] {5,6,7,8,9};
        k = 5;
        countNumberOFElementWithGivenXOR(arr, k);
        optimalWayToFindCountNumberOfElementWithGivenXOR(arr, k);*/
    }

    private static void countNumberOFElementWithGivenXOR(int[] arr, int k) {
        int count = 0;
        for (int i=0; i<arr.length;i++) {
            int xor = 0;
            for (int j=i; j< arr.length; j++) {
                xor ^= arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void optimalWayToFindCountNumberOfElementWithGivenXOR(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currentXor = 0;
        for (int i=0; i<arr.length;i++) {
            currentXor ^= arr[i];
            int target = currentXor ^ k;
            if (map.containsKey(target)) {
                count+= map.get(target);
            }
            map.put(currentXor, map.getOrDefault(currentXor, 0)+1);
        }
        System.out.println(count);
    }
}
