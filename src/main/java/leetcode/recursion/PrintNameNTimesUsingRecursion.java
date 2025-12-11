package leetcode.recursion;

/**
 * Given an integer N, write a program to print your name N times.
 *
 * Input: N = 3
 * Output: Ashish Ashish Ashish
 * Explanation: Name is printed 3 times.
 *
 * Input: N = 1
 * Output: Ashish
 * Explanation: Name is printed once.
 */
public class PrintNameNTimesUsingRecursion {
    public static void main(String[] args) {
        printNameNTimesWithReturnType("Vasanthraj", 4);
    }

    private static String printNameNTimesWithReturnType(String str, int i) {
        if (i ==0) {
            return str;
        } else {
            String rstr = printNameNTimesWithReturnType(str, i-1);
            System.out.println(rstr);
            return rstr;
        }
    }

    private static void printNameNTimesWithOutReturnType(String str, int i) {
        if (i ==0) {
            return;
        } else {
            System.out.println(str);
            printNameNTimesWithReturnType(str, i-1);
        }
    }

}
