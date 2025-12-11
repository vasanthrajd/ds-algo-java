package leetcode.strings;

public class ReverseTheSentence {
    public static void main(String[] args) {
        String str = "Java is powerful and versatile";
        System.out.println(reverseTheSentence(str));
        System.out.println(reverseTheCharacters(str));
        allPossibleStringTrickyQuestions("JavaIsPGM");
    }

    private static void allPossibleStringTrickyQuestions(String javaIsPGM) {

    }

    private static String reverseTheCharacters(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String reverseTheSentence(String str) {
        String[] modifiedStr = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=modifiedStr.length-1; i>-1; i-- ) {
            stringBuilder.append(modifiedStr[i]).append(" ");
        }
        return stringBuilder.toString();

    }
}
