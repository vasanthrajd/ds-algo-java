package leetcode.strings;

public class CompressStringByCount {
    public static void main(String[] args) {
        String[] str = new String[] {
                "aaabbcddddeee",
                "abcdef",
                "abcdeff",
                "aabcdeff"
        };
        for (String s : str) {
            compareWithOptimized(s);
        }
    }

    private static void copmareStringByCount(String str) {
        StringBuilder compressedString = new StringBuilder();
        int count = 0;

        for(int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else if (count ==0) {
                compressedString.append(str.charAt(i));
            } else {
                compressedString.append(str.charAt(i - 1)).append(count);
                count = 0;
            }
            if (i == str.length()-2 && count !=0) {
                compressedString.append(str.charAt(i)).append(count);
            }
        }
        System.out.println(compressedString.toString());
    }

    private static void compareWithOptimized(String str) {
        StringBuilder compressedStr = new StringBuilder();
        int count = 1;
        char currentChar = str.charAt(0);
        compressedStr.append(currentChar);
        for(int i=1; i<str.length(); i++) {
            if (currentChar == str.charAt(i)) {
                count= count + 1;
            } else {
                currentChar = str.charAt(i);
                compressedStr.append(count).append(currentChar);
                count = 1;
            }
        }
        compressedStr.append(count);
        System.out.println(compressedStr);
    }
}
