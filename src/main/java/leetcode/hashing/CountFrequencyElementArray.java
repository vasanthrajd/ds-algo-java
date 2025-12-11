package leetcode.hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequencyElementArray {
    public static void main(String[] args) {
        int[] i= new int[] {10,5,10,15,10,5};
        Map<Integer, Integer> map = Arrays.stream(i).boxed().collect(Collectors.toMap(key -> key, value -> 1, Integer::sum));
        map.forEach((key, value) -> System.out.println("KEY >> " + key + "  Value >> " + value));
    }

}
