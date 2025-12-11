package leetcode.math;

/**
 * An Armstrong number (also known as a narcissistic number) is a special type of number where the sum of each digit raised to the power of the total number of digits equals the number itself.
 *
 * Given an integer n, you need to determine if it's an Armstrong number.
 *
 * For a k-digit number to be an Armstrong number:
 *
 * Count the total number of digits (k)
 * Take each digit and raise it to the kth power
 * Sum all these powered values
 * If the sum equals the original number n, then it's an Armstrong number
 * Examples:
 *
 * 153 is an Armstrong number because it has 3 digits, and 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
 * 9474 is an Armstrong number because it has 4 digits, and 9⁴ + 4⁴ + 7⁴ + 4⁴ = 6561 + 256 + 2401 + 256 = 9474
 * 123 is not an Armstrong number because 1³ + 2³ + 3³ = 1 + 8 + 27 = 36 ≠ 123
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println("Is the given number armstrong number 153 >> "+ isArmstrongNumber(153));
        System.out.println("Is the given number armstrong number 154 >> "+ isArmstrongNumber(154));
    }

    private static boolean isArmstrongNumber(int n) {
        int digit = 0;
        int k = n;
        while (k != 0) {
            k = k/10;
            digit ++;
        }
        int sum =0;
        int digitCount = (int)Math.log10(n) + 1;
        int j = n;
        while (j !=0 ) {
            int temp = j % 10;
            sum += Math.pow(temp, digit);
            j = j / 10;
        }
        return n == sum;
    }
}
