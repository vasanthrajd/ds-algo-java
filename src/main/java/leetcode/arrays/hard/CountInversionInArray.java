package leetcode.arrays.hard;

/**
 * Given an array of N integers, count the inversion of the array (using merge-sort).
 *
 * Inversion of an array: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].
 *
 * Example 1:
 * Input Format: N = 5, array[] = {1,2,3,4,5}
 * Result: 0
 * Explanation: we have a sorted array and the sorted array has 0 inversions as for i < j you will never
 * find a pair such that A[j] < A[i]. More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so
 * this is not an inversion.
 *
 * Example 2:
 * Input Format: N = 5, array[] = {5,4,3,2,1}
 * Result: 10
 * Explanation: we have a reverse sorted array and we will get the maximum inversions as for i < j we will always
 * find a pair such that A[j] < A[i]. Example: 5 has index 0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3
 * which will satisfy out conditions and for reverse sorted array we will get maximum inversions and that is (n)*(n-1) / 2.
 * For above given array there is 4 + 3 + 2 + 1 = 10 inversions.
 *
 * Example 3:
 * Input Format: N = 5, array[] = {5,3,2,1,4}
 * Result: 7
 * Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and (1,4) as both are
 * not satisfy our condition.
 *
 * Applying Merge Sort will increase the changes of lesser number of loops.
 */
public class CountInversionInArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        int count = findCountOfInversionUsingMergeSort(arr);
        System.out.println("Count of Inversion is " + count);
        arr = new int[] {5,4,3,2,1};
        count = findCountOfInversionUsingMergeSort(arr);
        System.out.println("Count of Inversion is " + count);
        arr = new int[] {5,3,2,1,4};
        count = findCountOfInversionUsingMergeSort(arr);
        System.out.println("Count of Inversion is " + count);
    }

    private static int findCountOfInversionInTheGivenArray(int[] arr) {
        int count = 0;
        int left = 0;
        int right = arr.length-1;
        int len = arr.length;
        while (left < len) {
            for (int j=right; j>left; j--) {
                if (arr[j] < arr[left]) {
                    count++;
                }
            }
            left++;
        }
        return count;
    }

    private static int findCountOfInversionUsingMergeSort(int[] arr) {
        //int count =0;
        return findInversionUsingMergeSort(arr, 0, arr.length-1);
        //return count;
    }

    private static int findInversionUsingMergeSort(int[] arr, int low, int high) {
        int count=0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high)/2;
        count +=findInversionUsingMergeSort(arr, low, mid);
        count +=findInversionUsingMergeSort(arr, mid+1, high);
        count += mergeBothInversionArray(arr, low, mid, high);
        return count;
    }

    private static int mergeBothInversionArray(int[] arr, int low, int mid, int high) {
        int left = low, right = mid + 1;
        int[] temp = new int[high - low + 1];
        int k=0;
        int count=0;
        while (left <=mid && right <=high) {
            if (arr[left] < arr[right] ){
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (mid - left + 1); // Count inversions
            }
        }
        while (left<=mid) {
            temp[k++] = arr[left++];
        }
        while (right<=high) {
            temp[k++] = arr[right++];
        }
        for (int i=low; i<=high; i++) {
            arr[i] = temp[i-low];
        }
        return count;
    }

}
