package leetcode.recursion;

/**
 * Given a number X,  print its factorial.
 *
 * To obtain the factorial of a number, it has to be multiplied by all the whole numbers preceding it. More precisely
 * X! = X*(X-1)*(X-2) … 1.
 */
public class FactorialOfGivenNumberUsingRecursion {
    public static void main(String[] args) {
        System.out.println(factorialInRecursion(5));
    }

    private static int factorialInRecursion(int i) {
        if (i==1) {
            return i;
        } else {
            return i * factorialInRecursion(i-1);
        }
    }
}
