package leetcode.arrays.hard;

import java.util.*;

/**
 * Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array.
 * The output can be returned in any order.
 *
 * Example 1:
 * Input:
 *  nums = [1, 2, 1, 1, 3, 2]
 * Output:
 *  [1]
 * Explanation:
 *  Here, n / 3 = 6 / 3 = 2.
 * Therefore, the elements appearing 3 or more times are: [1].
 *
 * Example 2:
 * Input:
 *  nums = [1, 2, 1, 1, 3, 2, 2]
 * Output:
 *  [1, 2]
 * Explanation:
 *  Here, n / 3 = 7 / 3 = 2.
 * Therefore, the elements appearing 3 or more times are: [1, 2].
 *
 * Clue : In any given array if there is no possibility of having more than two number that can occur in the array of N/3 times.
 */
public class FindElementThatAppearsMoreThanNBy3Times {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 1, 1, 3, 2};
        findNumberAppearingMoreThanNBy3TimesInArray(arr);
        arr = new int[] {1, 2, 1, 1, 3, 2, 2};
        findNumberAppearingMoreThanNBy3TimesInArray(arr);
    }

    private static void findNumberAppearingMoreThanNBy3Times(int[] arr) {
        int len = arr.length;
        int time = len/3;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i:arr) {
            if (map.containsKey(i)) {
                int count = map.get(i) + 1;
                if (count > time) {
                    set.add(i);
                }
                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println(set.toString());
    }

    private static void findNumberAppearingMoreThanNBy3TimesInArray(int[] arr) {
        int len = arr.length;
        int times = len/3;
        int[] result = new int[2];
        int index = 0;
        int currentTracking =1;
        Arrays.sort(arr);
        for (int i=1; i<arr.length; i++) {
            if (arr[i-1] == arr[i]) {
                currentTracking++;
                if (currentTracking > times) {
                    result[index] = arr[i];
                    index++;
                }
            } else {
                currentTracking=1;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
