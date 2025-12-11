package leetcode.strings;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class StringMagicTricks {

    public static void main(String[] args) throws Exception {
        System.out.println("=== STRING MAGIC TRICKS DEMONSTRATION ===\n");

        demonstrateStringLiteralVsNew();
        demonstrateStringComparison();
        demonstrateStringImmutability();
        demonstrateStringPoolBehavior();
        demonstrateStringIntern();
        demonstrateStringMemoryLocation();
        demonstrateStringConcatenation();
        demonstrateStringMethodsBehavior();
        demonstrateStringBuilderVsString();
        demonstrateReflectionStringModification();
        demonstrateUnicodeStrings();
        demonstrateStringPerformance();
    }

    /**
     * 1. String Literal vs String Object
     */
    public static void demonstrateStringLiteralVsNew() {
        System.out.println("1. STRING LITERAL vs NEW STRING OBJECT");
        System.out.println("=".repeat(50));

        // String literal - goes to string pool
        String literal1 = "Hello";
        String literal2 = "Hello";

        // String object - created in heap
        String object1 = new String("Hello");
        String object2 = new String("Hello");

        System.out.println("String literal1 = \"Hello\";");
        System.out.println("String literal2 = \"Hello\";");
        System.out.println("String object1 = new String(\"Hello\");");
        System.out.println("String object2 = new String(\"Hello\");");
        System.out.println();

        System.out.println("literal1 == literal2 : " + (literal1 == literal2)); // true
        System.out.println("object1 == object2   : " + (object1 == object2));   // false
        System.out.println("literal1 == object1  : " + (literal1 == object1));  // false
        System.out.println();
    }

    /**
     * 2. String Comparison (== vs equals)
     */
    public static void demonstrateStringComparison() {
        System.out.println("2. STRING COMPARISON (== vs equals)");
        System.out.println("=".repeat(50));

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String("Java").intern();

        System.out.println("s1 = \"Java\";");
        System.out.println("s2 = \"Java\";");
        System.out.println("s3 = new String(\"Java\");");
        System.out.println("s4 = new String(\"Java\").intern();");
        System.out.println();

        System.out.println("s1 == s2      : " + (s1 == s2));      // true
        System.out.println("s1 == s3      : " + (s1 == s3));      // false
        System.out.println("s1 == s4      : " + (s1 == s4));      // true
        System.out.println("s1.equals(s2) : " + s1.equals(s2));   // true
        System.out.println("s1.equals(s3) : " + s1.equals(s3));   // true
        System.out.println();
    }

    /**
     * 3. String Immutability Demonstration
     */
    public static void demonstrateStringImmutability() {
        System.out.println("3. STRING IMMUTABILITY");
        System.out.println("=".repeat(50));

        String original = "Hello";
        System.out.println("Original string: " + original);
        System.out.println("Original hash code: " + System.identityHashCode(original));

        String modified = original.concat(" World");
        System.out.println("After concat: " + modified);
        System.out.println("Modified hash code: " + System.identityHashCode(modified));
        System.out.println("Original unchanged: " + original);
        System.out.println("Are they same object? " + (original == modified));
        System.out.println();

        // Another example with uppercase
        String upper = original.toUpperCase();
        System.out.println("Original: " + original + " (" + System.identityHashCode(original) + ")");
        System.out.println("Uppercase: " + upper + " (" + System.identityHashCode(upper) + ")");
        System.out.println();
    }

    /**
     * 4. String Pool Behavior
     */
    public static void demonstrateStringPoolBehavior() {
        System.out.println("4. STRING POOL BEHAVIOR");
        System.out.println("=".repeat(50));

        // Compile-time constants
        String compileTime1 = "Hello" + "World";
        String compileTime2 = "HelloWorld";
        System.out.println("compileTime1 == compileTime2 : " + (compileTime1 == compileTime2)); // true

        // Runtime concatenation
        String hello = "Hello";
        String world = "World";
        String runtimeConcat = hello + world;
        System.out.println("runtimeConcat == compileTime1 : " + (runtimeConcat == compileTime1)); // false

        // Final variables (treated as compile-time constants)
        final String finalHello = "Hello";
        final String finalWorld = "World";
        String finalConcat = finalHello + finalWorld;
        System.out.println("finalConcat == compileTime1 : " + (finalConcat == compileTime1)); // true

        // Non-final variables
        String nonFinalHello = "Hello";
        String nonFinalWorld = "World";
        String nonFinalConcat = nonFinalHello + nonFinalWorld;
        System.out.println("nonFinalConcat == compileTime1 : " + (nonFinalConcat == compileTime1)); // false
        System.out.println();
    }

    /**
     * 5. String intern() method
     */
    public static void demonstrateStringIntern() {
        System.out.println("5. STRING INTERN METHOD");
        System.out.println("=".repeat(50));

        String s1 = new String("Java");
        String s2 = s1.intern();
        String s3 = "Java";

        System.out.println("s1 = new String(\"Java\");");
        System.out.println("s2 = s1.intern();");
        System.out.println("s3 = \"Java\";");
        System.out.println();

        System.out.println("s1 == s2 : " + (s1 == s2)); // false
        System.out.println("s2 == s3 : " + (s2 == s3)); // true
        System.out.println("s1 == s3 : " + (s1 == s3)); // false
        System.out.println();

        // Interesting case with dynamic strings
        String dynamic = new StringBuilder().append("Ja").append("va").toString();
        System.out.println("dynamic = new StringBuilder().append(\"Ja\").append(\"va\").toString();");
        System.out.println("dynamic == \"Java\" : " + (dynamic == "Java")); // false
        System.out.println("dynamic.intern() == \"Java\" : " + (dynamic.intern() == "Java")); // true
        System.out.println();
    }

    /**
     * 6. String Memory Location Analysis
     */
    public static void demonstrateStringMemoryLocation() throws Exception {
        System.out.println("6. STRING MEMORY LOCATION ANALYSIS");
        System.out.println("=".repeat(50));

        // Demonstrate that strings are in heap
        String heapString = new String("I'm in heap");
        String poolString = "I'm in pool";

        System.out.println("All strings are in Heap, but:");
        System.out.println("- String literals: String Pool (Heap area)");
        System.out.println("- new String(): Regular Heap");
        System.out.println();

        // Show memory addresses (approximate)
        System.out.println("heapString identityHashCode: " + System.identityHashCode(heapString));
        System.out.println("poolString identityHashCode: " + System.identityHashCode(poolString));
        System.out.println();
    }

    /**
     * 7. String Concatenation Tricks
     */
    public static void demonstrateStringConcatenation() {
        System.out.println("7. STRING CONCATENATION TRICKS");
        System.out.println("=".repeat(50));

        // Null concatenation
        String nullStr = null;
        String result = nullStr + " suffix";
        System.out.println("null + \" suffix\" = \"" + result + "\"");

        // Number concatenation
        String numConcat = "Result: " + 10 + 20;
        System.out.println("\"Result: \" + 10 + 20 = \"" + numConcat + "\"");

        String numConcat2 = "Result: " + (10 + 20);
        System.out.println("\"Result: \" + (10 + 20) = \"" + numConcat2 + "\"");

        // Char array behavior
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String fromChars = new String(chars);
        System.out.println("new String(char[]) creates: \"" + fromChars + "\"");
        System.out.println();
    }

    /**
     * 8. Interesting String Methods Behavior
     */
    public static void demonstrateStringMethodsBehavior() {
        System.out.println("8. STRING METHODS BEHAVIOR");
        System.out.println("=".repeat(50));

        String text = "  Hello World  ";

        System.out.println("Original: \"" + text + "\"");
        System.out.println("trim(): \"" + text.trim() + "\"");
        System.out.println("substring(2, 7): \"" + text.substring(2, 7) + "\"");
        System.out.println("replace('l', 'L'): \"" + text.replace('l', 'L') + "\"");

        // Empty vs null
        String empty = "";
        String nullString = null;
        System.out.println("empty.isEmpty(): " + empty.isEmpty());
        // System.out.println("nullString.isEmpty(): " + nullString.isEmpty()); // NPE!

        System.out.println();
    }

    /**
     * 9. StringBuilder vs String
     */
    public static void demonstrateStringBuilderVsString() {
        System.out.println("9. STRINGBUILDER vs STRING");
        System.out.println("=".repeat(50));

        // String concatenation in loop (inefficient)
        String result = "";
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            result += i;
        }
        long stringTime = System.nanoTime() - startTime;

        // StringBuilder in loop (efficient)
        StringBuilder sb = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        long builderTime = System.nanoTime() - startTime;

        System.out.println("String concatenation time: " + stringTime / 1000000 + " ms");
        System.out.println("StringBuilder time: " + builderTime / 1000000 + " ms");
        System.out.println("StringBuilder is " + (stringTime / builderTime) + "x faster");
        System.out.println();
    }

    /**
     * 10. Reflection String Modification (DANGEROUS - breaks immutability)
     */
    public static void demonstrateReflectionStringModification() throws Exception {
        System.out.println("10. REFLECTION STRING MODIFICATION (Breaking Immutability)");
        System.out.println("=".repeat(50));

        String immutable = "I am immutable";
        System.out.println("Before modification: " + immutable);
        System.out.println("Hash code: " + System.identityHashCode(immutable));

        // Using reflection to modify String (VERY DANGEROUS!)
        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);
        char[] value = (char[]) valueField.get(immutable);
        value[0] = 'i';
        value[5] = 'I';
        value[6] = 'S';

        System.out.println("After modification: " + immutable);
        System.out.println("Hash code: " + System.identityHashCode(immutable));
        System.out.println("WARNING: This breaks String immutability contract!");
        System.out.println();
    }

    /**
     * 11. Unicode and Special String Behaviors
     */
    public static void demonstrateUnicodeStrings() {
        System.out.println("11. UNICODE AND SPECIAL STRING BEHAVIORS");
        System.out.println("=".repeat(50));

        // Unicode characters
        String unicode = "Hello \uD83C\uDF0D World \u2764";
        System.out.println("Unicode string: " + unicode);
        System.out.println("Length: " + unicode.length());
        System.out.println("Code point count: " + unicode.codePointCount(0, unicode.length()));

        // Empty strings
        String empty1 = "";
        String empty2 = new String();
        System.out.println("empty1 == empty2: " + (empty1 == empty2)); // false
        System.out.println("empty1.equals(empty2): " + empty1.equals(empty2)); // true

        // String with only spaces
        String spaces = "   ";
        System.out.println("spaces.trim().isEmpty(): " + spaces.trim().isEmpty());
        System.out.println();
    }

    /**
     * 12. String Performance Considerations
     */
    public static void demonstrateStringPerformance() {
        System.out.println("12. STRING PERFORMANCE CONSIDERATIONS");
        System.out.println("=".repeat(50));

        List<String> strings = new ArrayList<>();

        // Memory inefficient
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (int i = 0; i < 10000; i++) {
            strings.add(new String("Hello")); // Creates new objects
        }
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory with 'new String(): " + (memoryAfter - memoryBefore) + " bytes");

        strings.clear();
        System.gc();

        // Memory efficient
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (int i = 0; i < 10000; i++) {
            strings.add("Hello"); // Reuses string pool
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory with string literal: " + (memoryAfter - memoryBefore) + " bytes");
        System.out.println();
    }
}