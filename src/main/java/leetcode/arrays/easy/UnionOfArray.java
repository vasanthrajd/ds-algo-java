package leetcode.arrays.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
 *
 * The union of two arrays can be defined as the common and distinct elements in the two arrays.
 *
 * NOTE: Elements in the union should be in ascending order.
 *
 * Input:n = 5,m = 5 arr1[] = {1,2,3,4,5}  arr2[] = {2,3,4,4,5}
 * Output: {1,2,3,4,5}
 *
 * Explanation: Common Elements in arr1 and arr2  are:  2,3,4,5
 *
 * Distnict Elements in arr1 are : 1
 * Distnict Elemennts in arr2 are : No distinct elements.
 *
 * Union of arr1 and arr2 is {1,2,3,4,5}
 */
public class UnionOfArray {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,3,4,5};
        int[] arr2 = new int[] {2,3,4,4,5};
        unionArrayUsingTwoPointers(arr1, arr2);
        System.out.println(" ");
        arr1 = new int[] {1,2,3,4,5,6,7,8,9,10};
        arr2 = new int[] {2,3,4,4,5,11,12};
        unionArrayUsingTwoPointers(arr1, arr2);
    }

    private static void unionArray(int[] arr1, int[] arr2) {
        int lenOfArray1 = arr1.length;
        int lenOfArray2 = arr2.length;
        int highestEnd= lenOfArray1 > lenOfArray2 ? lenOfArray1 : lenOfArray2;
        int lowestEnd = lenOfArray1 > lenOfArray2 ? lenOfArray2 : lenOfArray1;
        int[] resultArray = new int[lenOfArray1 + lenOfArray2];
        int resultIndex = 0;
        for (int i=0; i<lowestEnd;i++) {
            if (arr1[i] == arr2[i]) {
                resultArray[resultIndex] = arr1[i];
                resultIndex++;
            } else if (arr1[i] < arr2[i]){
                resultArray[resultIndex] = arr1[i];
                resultIndex++;
                resultArray[resultIndex] = arr2[i];
            } else {
                resultArray[resultIndex] = arr2[i];
                resultIndex++;
                resultArray[resultIndex] = arr1[i];
            }

        }
        for (;lowestEnd < highestEnd; lowestEnd++) {
            int i = arr1.length > arr2.length ? arr1[lowestEnd] : arr2[lowestEnd];
            resultArray[resultIndex] = i;
            resultIndex++;
        }
        System.out.println(Arrays.toString(resultArray));
    }

    private static void optimalApproach(int[] arr1, int[] arr2) {

        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());;
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());;
        Set<Integer> resultSet = new TreeSet<>();
        resultSet.addAll(set1);
        resultSet.addAll(set2);
        resultSet.forEach(System.out::println);

    }
    private static void unionArrayUsingTwoPointers(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int arr1Pointer = 0;
        int arr1Length = arr1.length;
        int arr2Pointer = 0;
        int arr2Length = arr2.length;
        while (arr1Pointer < arr1Length && arr2Pointer < arr2Length) {
            if (arr1[arr1Pointer] == arr2[arr2Pointer]) {
                result.add(arr1[arr1Pointer]);
                arr1Pointer++;
                arr2Pointer++;
            }
            else if (arr1[arr1Pointer] < arr2[arr2Pointer]) {
                if (result.isEmpty() || result.get(result.size()-1) !=arr1[arr1Pointer])
                    result.add(arr1[arr1Pointer]);
                arr1Pointer++;
            }
            else if (arr1[arr1Pointer] > arr2[arr2Pointer]) {
                if (result.isEmpty() || result.get(result.size()-1) !=arr2[arr2Pointer])
                    result.add(arr2[arr2Pointer]);
                arr2Pointer++;
            }
        }
        while (arr1Pointer < arr1Length) {
            if (result.isEmpty() || result.get(result.size()-1) !=arr1[arr1Pointer])
                result.add(arr1[arr1Pointer]);
            arr1Pointer++;
        }
        while (arr2Pointer < arr2Length) {
            if (result.isEmpty() || result.get(result.size()-1) !=arr2[arr2Pointer])
                result.add(arr2[arr2Pointer]);
            arr2Pointer++;
        }
        result.forEach(integer -> {
            System.out.print(integer + " ");
        });
    }

}
