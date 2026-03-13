package leetcode.strings;

public class Permutation {
    static int calls = 0;
    public static void main(String[] args) {
        Integer count = 0;
        //permutation("Help", "", count);
        System.out.println("Permutation Executed " +  permutation("Help", ""));
        System.out.println("Recursive Calls " + calls);
    }

    static int permutation(String str, String prefix) {
        calls++;
        if (str.length() == 0) {
            System.out.println(prefix);
            return 1;
        } else {
            int count = 0;
            for (int i=0; i<str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i+1);

                count +=permutation(rem, prefix + str.charAt(i));
            }
            return count;
        }
    }
}
