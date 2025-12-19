package leetcode.arrays.hard;

/**
 * Given an array of numbers, you need to return the count of reverse pairs.
 * Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].
 *
 * Example 1:
 * Input:
 *  N = 5, array[] = {1,3,2,3,1)
 * Output
 * : 2
 * Explanation:
 *  The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.
 *
 * Example 2:
 * Input:
 *  N = 4, array[] = {3,2,1,4}
 * Output:
 *  1
 * Explaination:
 * There is only 1 pair  ( 3 , 1 ) that satisfy the condition arr[i] > 2*arr[j]
 */
public class FindCountOfReversePairs {
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,3,1};
        int count = findCountOfReversePairs(arr);
        System.out.println("Count of Reverse Pairs >>" + count);
        arr = new int[] {3,2,1,4};
        count = findCountOfReversePairs(arr);
        System.out.println("Count of Reverse Pairs >>" + count);
    }

    private static int findCountOfReversePairs(int[] arr) {
        return countOfReversePairsUsingMergeSort(arr, 0, arr.length-1);
    }

    private static int countOfReversePairsUsingMergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >=high) return count;
        int mid = (low + high)/2;
        count += countOfReversePairsUsingMergeSort(arr, low, mid);
        count += countOfReversePairsUsingMergeSort(arr, mid+1, high);
        count += countPairs(arr, low, mid, high);
        mergeSortedResult(arr, low, mid, high);
        return count;
    }

    private static void mergeSortedResult(int[] arr, int low, int mid, int high) {
        int left = low, right = mid+1;
        int[] temp = new int[high - low + 1];
        int k=0;
        while (left<=mid && right <=high) {
            if (arr[left] < arr[right]) {
                temp[k++] = arr[left++];
            }  else {
                temp[k++] = arr[right++];
            }
        }
        while (left <=mid) {
            temp[k++] = arr[left++];
        }
        while (right <=high) {
            temp[k++] = arr[right++];
        }
        for (int i=low; i<=high; i++) {
            arr[i] = temp[i-low];
        }
    }


    /*private static int countReversePairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i<=mid;i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            count += (right -(mid +1));
        }
        return count;
    }*/

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

}
