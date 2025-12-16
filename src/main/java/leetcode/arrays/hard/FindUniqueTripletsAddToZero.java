package leetcode.arrays.hard;

import java.util.*;

/**
 * Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero.
 * In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]]
 * such that i!=j, j!=k, k!=i, and their sum is equal to zero.
 * <p>
 * <p>
 * Example 1:
 * Input:
 * nums = [-1,0,1,2,-1,-4]
 * Output:
 * [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k
 * <p>
 * Example 2:
 * Input:
 * nums=[-1,0,1,0]
 * Output:
 * Output: [[-1,0,1],[-1,1,0]]
 * Explanation:
 * Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k
 */
public class FindUniqueTripletsAddToZero {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        uniqueTripletArrayWhichMeetTargetSum(arr);

        arr = new int[]{-1, 0, 1, 0};
        uniqueTripletArrayWhichMeetTargetSum(arr);
    }

    private static void subArrayWithTargetSumSetToZero(int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        while (left < right) {
            for (int i = right; i > left; i--) {
                if ((arr[left] + arr[left + 1] + arr[i]) == 0) {
                    List<Integer> tmpLiist = new ArrayList<>();
                    tmpLiist.add(arr[left]);
                    tmpLiist.add(arr[left + 1]);
                    tmpLiist.add(arr[i]);
                    list.add(tmpLiist);
                }
            }
            left++;
        }
        System.out.println(list.toString());
    }

    // -1,0,1,2,-1,-4
    // -4, -1, -1, 0, 1,2
    // [[-1,-1,2],[-1,0,1]]
    private static void tripletsArrayWhichMeetTargetSumUsingSet(int[] arr) {
        Arrays.sort(arr);

        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int third = -(arr[i] + arr[j]);

                if (hashset.contains(third)) {
                    List<Integer> interimList = List.of(arr[i], arr[j], third);
                    list.add(interimList);
                }
                hashset.add(arr[j]);
            }
        }
        System.out.println(list.toString());
    }

    private static void uniqueTripletArrayWhichMeetTargetSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            int left = i+1;
            int right = arr.length-1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];
                if (sum ==0) {
                    List interimLeft = List.of(arr[i], arr[left], arr[right]);
                    ans.add(interimLeft);
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left-1]) left++;
                    while (left < right && arr[right] == arr[right+1]) right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        System.out.println(ans.toString());
    }
}
