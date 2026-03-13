package leetcode.binarysearch;

import java.util.Arrays;

/**
 * Heap is implemented in Array
 */
public class HeapInArray {
    public static void main(String[] args) {
        /*int[] heapArray = new int[]{50, 30, 20, 15, 10, 8, 16};
        System.out.println(Arrays.toString(sortThisMaxHeapArray(heapArray)));
        heapArray = new int[]{40, 30, 15, 10, 20};
        System.out.println(Arrays.toString(sortThisMaxHeapArray(heapArray)));
        heapArray = new int[]{10, 20, 15, 12, 40, 25, 18};
        System.out.println(Arrays.toString(heapify(heapArray)));*/

        int[] heapArray = new int[]{10, 20, 15, 12, 40, 25, 18};
        heapArray = heapify(heapArray);
        System.out.println(Arrays.toString(heapArray));
        //  40, 20, 25, 12, 10, 15, 18
        //          40
        //   20               25
        //12   10          15   18

        System.out.println(Arrays.toString(sortThisMaxHeapArray(heapArray)));

    }

    private static int[] sortThisMaxHeapArray(int[] heapArray) {
        int heapCount = heapArray.length - 1;
        int right = heapArray.length;
        while (right != 0) {
            int elementToReplace = heapArray[0];
            heapArray[0] = heapArray[heapCount];
            heapArray[heapCount] = elementToReplace;
            heapCount--;
            for (int i = 0; (2 * i) + 2 <= heapCount;) {
                int leftNode = heapArray[(2 * i) + 1];
                int rightNode = heapArray[(2 * i) + 2];
                int temp = heapArray[i];
                if (leftNode > rightNode && heapArray[i] < leftNode) {
                    heapArray[i] = leftNode;
                    heapArray[2 * i + 1] = temp;
                    i = (2 * i) + 1;
                } else if (heapArray[i] < rightNode) {
                    heapArray[i] = rightNode;
                    heapArray[(2 * i) + 2] = temp;
                    i = (2 * i) + 2;
                } else {
                    i = i + 1;
                }
            }
            right--;
        }
        return heapArray;
    }

    // [10, 20, 15, 12, 40, 25, 18]
    //      10
    //  20        15
    //12 40     25  18
    // [40, 20, 25, 12, 10, 15, 18]
    private static int[] heapify(int[] heapArray) {
        int right = heapArray.length - 1;
        int length = heapArray.length;
        while (right >= 0) {
            for (int i = right; ((2 * i) + 2) < length; ) {
                System.out.println("Processing at right index node " + right);
                int leftNode = heapArray[(2 * i) +1];
                int rightNode = heapArray[(2 * i) +2 ];
                int temp = heapArray[i];
                System.out.println("Comparing these two numbers (" + leftNode + " == " + rightNode + " ) ");
                if (leftNode > rightNode && heapArray[i] < leftNode) {
                    heapArray[i] = leftNode;
                    heapArray[2 * i +1] = temp;
                    i = (2 * i) + 1;
                } else if (heapArray[i] < rightNode) {
                    heapArray[i] = rightNode;
                    heapArray[(2 * i) +2] = temp;
                    i = (2 * i) + 2;
                }
            }
            right--;
        }
        return heapArray;
    }

}
