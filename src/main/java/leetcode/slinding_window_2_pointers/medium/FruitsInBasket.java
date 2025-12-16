package leetcode.slinding_window_2_pointers.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees,
 * where fruits[i] denotes the kind of fruit produced by the ith tree.
 * The goal is to gather as much fruit as possible, adhering to the owner's stringent rules :
 *
 * There are two baskets available, and each basket can only contain one kind of fruit.
 * The quantity of fruit each basket can contain is unlimited.
 *
 * Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree.
 * One of the baskets must hold the harvested fruits.
 * Once reaching a tree with fruit that cannot fit into any basket, stop.
 *
 * Input :fruits = [1, 2, 1]
 * Output :3
 * Explanation : We will start from first tree.
 * The first tree produces the fruit of kind '1' and we will put that in the first basket.
 * The second tree produces the fruit of kind '2' and we will put that in the second basket.
 * The third tree produces the fruit of kind '1' and we have first basket that is already holding fruit of kind '1'.
 * So we will put it in first basket.
 * Hence we were able to collect total of 3 fruits.
 *
 *
 * Input : fruits = [1, 2, 3, 2, 2]
 * Output : 4
 * Explanation : we will start from second tree.
 * The first basket contains fruits from second , fourth and fifth.
 * The second basket will contain fruit from third tree.
 * Hence we collected total of 4 fruits.
 */
public class FruitsInBasket {
    public static void main(String[] args) {
        int[] arrary = new int[] {1, 2, 3, 2, 2};
        solveUsingSlidingWindowApproach(arrary);
        arrary = new int[] {1, 2, 1};
        solveUsingSlidingWindowApproach(arrary);
    }

    private static void findTotalFruitTobeCollectedUsingMap(int[] arrary) {
        int max =0;
        int prevMax = max;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< arrary.length; i++) {
            if (map.containsKey(arrary[i])) {
                map.put(arrary[i], map.get(arrary[i])+1);
            } else {
                map.put(arrary[i], 1);
            }
            if (max > prevMax) {
                prevMax = max;
            }
            max = Math.max(max, map.get(arrary[i]));
        }
        System.out.println("Maximum ==" + map.get(max) + " Second max ==" + map.get(prevMax));
        System.out.println("Total Count of Friuts to be collected is " + (map.get(max) + map.get(prevMax)));
    }

    //[1, 2, 3, 2, 2]
    private static void solveUsingSlidingWindowApproach(int[] arr) {
        // Variables to track max window size
        int maxlen = 0;
        // Track last and second last fruit types
        int lastFruit = -1, secondLastFruit = -1;
        // Count of current window and streak of last fruit
        int currCount = 0, lastFruitStreak = 0;
        // Traverse through each fruit
        for (int fruit : arr) {
            // If fruit matches last two, expand window
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currCount++;
            } else {
                // Reset window size to streak + 1
                currCount = lastFruitStreak + 1;
            }
            // Update lastFruit streak and fruit types
            if (fruit == lastFruit) {
                lastFruitStreak++;
            } else {
                lastFruitStreak = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }
            // Update max window size
            maxlen = Math.max(maxlen, currCount);
        }
        System.out.println(maxlen);
    }
}
