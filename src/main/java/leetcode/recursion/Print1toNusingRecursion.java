package leetcode.recursion;

/**
 * Input: N = 4
 * Output: 1, 2, 3, 4
 * Explanation: All the numbers from 1 to 4 are printed.
 */
public class Print1toNusingRecursion {
    public static void main(String[] args) {
        print1ToNUsingRecursion(5);
        //printNos(5);
    }

    private static void print1ToNUsingRecursion(int i) {
        if (i==0) {
            return;
        } else {
            //int n = i-1;
            print1ToNUsingRecursion(i-1);
            System.out.println(i);
        }
    }

    public static void printNos(int N) {
        // Base case: if N is 0, simply return without doing anything
        if (N == 0) {
            return;
        }

        // Recursive call: first, process (print) all numbers from N-1 down to 1
        printNos(N - 1);

        // After the recursive call, print the current value of N
        System.out.print(N + " ");
    }
}
