package leetcode.arrays.medium;

/**
 * You are given an array of prices where prices[i] is the price of a given stock on an ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to
 * sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note: That buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr = new int[] {7,1,5,3,6,4};
        System.out.println("Maximum Profit I can get from the Given Array of Trade Day is >" + findMaxProfitFromTradeArrays(arr));
        arr = new int[] {7,6,4,3,1};
        System.out.println("Maximum Profit I can get from the Given Array of Trade Day is >" + findMaxProfitFromTradeArrays(arr));
    }

    private static int findMaxProfitFromTradeArrays(int[] arr) {
        int profit = 0;
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int internalDifference = 0;
            if (arr[left]  > arr[right]) {
                left++;
            } else {
                internalDifference = arr[right] - arr[left];
                right--;
            }
            if (profit < internalDifference) {
                profit = internalDifference;
            }
        }
        return profit;
    }
}
