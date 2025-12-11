package org.example;

public class App {

    public static void main(String[] args) {
        String str = "Native Image is Awesome in GraalVM";
        String reversedStr = reverseString(str);
        System.out.println(reversedStr);
    }

    static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
