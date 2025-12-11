package leetcode.arrays.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an integer array nums of size n, return the majority element of the array.
 *
 * The majority element of an array is an element that appears more than n/2 times in the array.
 * The array is guaranteed to have a majority element.
 * Example 1:
 * Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
 * Output: 7
 * Explanation: The number 7 appears 5 times in the 9-sized array, making it the most frequent element.
 *
 * Input: nums = [1, 1, 1, 2, 1, 2]
 * Output: 1
 * Explanation: The number 1 appears 4 times in the 6-sized array, making it the most frequent element.
 *
 */
public class MajorityElementsOccurs {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int k = arr.length/2;
        System.out.println("Majority of Elements in the given array is >> " + findMajorityOfElement(arr, k));
        arr = new int[] {1, 1, 1, 2, 1, 2};
        k = arr.length/2;
        System.out.println("Majority of Elements in the given array is >> " + findMajorityOfElement(arr, k));
        arr = new int[] {1, 1, 2, 2, 1, 2};
        k = arr.length/2;
        System.out.println("Majority of Elements in the given array is >> " + findMajorityOfElement(arr, k));
    }

    private static int findMajorityOfElement(int[] arr, int k) {

        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > k)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }
}
