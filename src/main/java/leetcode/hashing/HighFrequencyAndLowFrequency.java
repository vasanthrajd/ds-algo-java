package leetcode.hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HighFrequencyAndLowFrequency {
    public static void main(String[] args) {
        int[] i= new int[] {10,5,10,15,10,5};
        Map<Integer, Integer> map = Arrays.stream(i).boxed().collect(Collectors.toMap(key -> key, value -> 1, Integer::sum));
        //map.forEach((key, value) -> System.out.println("KEY >> " + key + "  Value >> " + value));
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            //System.out.println("KEY >> " + entry.getKey() + "  Value >> " + entry.getValue());
            System.out.println("Comparing >> " + entry.getValue() + "  with max value Value >> " + map.getOrDefault(max, 0));
            if (entry.getValue() > map.getOrDefault(max, 0)) {
                max = entry.getKey();
            }
            if (entry.getValue() < min) {
                min = entry.getKey();
            }
        }

        System.out.println("Maximum occurence is for the key >>" + max);
        System.out.println("Minimum occurence is for the key >>" + min);
    }
}

