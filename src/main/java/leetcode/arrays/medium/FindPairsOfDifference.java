package leetcode.arrays.medium;

import java.util.*;

public class FindPairsOfDifference {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,6,8,2,7};
        int diffNumber = 4;
        System.out.println("Number of Pairs with the Different Number is " + pairOfNumberInArrWithDifference(arr, diffNumber));
    }

    private static int pairOfNumberInArrWithDifference(int[] arr, int diffNumber) {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            hashtable.put(arr[i], 1);
        }
        for (int i=0; i<arr.length;i++) {
            int forwardDifference = arr[i] + diffNumber;
            int backwardDifference = arr[i] - diffNumber;
            if (hashtable.containsKey(forwardDifference) || hashtable.containsKey(backwardDifference))  {
                System.out.println(arr[i]);
                set.add(arr[i]);
            }
        }
        return set.size();
    }
}
