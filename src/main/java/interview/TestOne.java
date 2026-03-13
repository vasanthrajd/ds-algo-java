package interview;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestOne {
    public static void main(String[] args) {
        failFasException();
    }

    static void failFasException() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(5);
            add(5);
            add(5);
        }};

        for (int i=0; i<list.size(); i++) {
            if (i >1) {
                    list.removeLast();
            }
            //System.out.println(list.get(i));
        }
        System.out.println(list);
        for(Integer i:list) {
            if (i%2==0) list.remove(i);
        }
        System.out.println(list);
    }

    static void sumOfAllEvenNumbersInTheList() {
        int[] arr = new int[]{1, 4, 6, 7, 9, 10, 10, 123, 123};
        System.out.println(Arrays.stream(arr).filter(ints -> ints % 2 == 0).reduce(0, Integer::sum));
    }

    static void collectUniqueCharacterInFromListOfString() {
        String[] str = new String[]{"abc", "bce", "xyz", "ecf"};

        Arrays.stream(str)
                .flatMapToInt(String::chars)
                .mapToObj(operand -> (char) operand)
                .collect(Collectors.toSet())
                .forEach(System.out::println);


    }

    static void processFile() {

        try (Stream<String> lines = Files.lines(Path.of("D:\\vasanth-git\\ds-algo-java\\src\\main\\java\\leetcode\\arrays\\CheckDuplicatesInArray.java"))) {
            Map<String, Long> wordFrequency = lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

            wordFrequency.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(5)
                    .forEach(stringLongEntry -> System.out.println(stringLongEntry.getKey() + " count is >> " + stringLongEntry.getValue()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void processList() {
        List<Student> studentList = new ArrayList<>();

        Random random = new Random();

        IntStream.range(0, 10).forEach(value -> {
            if (value % 2 == 0) {
                studentList.add(new Student("name " + (value % 2), 1, "school " + (value % 2)));
            } else {
                studentList.add(new Student("name " + value, random.nextInt(10), "school " + (value)));
            }
        });
        //studentList.forEach(System.out::println);
        System.out.println("---------------");

        //studentList.stream().distinct().forEach(System.out::println);


        //studentList.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getSchoolName)).distinct().forEach(System.out::println);

        System.out.println(studentList.stream().max(Comparator.comparing(Student::getAge)).get());
    }

    static class Student implements Comparable<Student> {
        private final String name;
        private final Integer age;
        private final String schoolName;

        public Student(String name, Integer age, String schoolName) {
            this.name = name;
            this.age = age;
            this.schoolName = schoolName;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", schoolName='" + schoolName + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getSchoolName() {
            return schoolName;
        }

        @Override
        public int compareTo(Student o) {
            int ageComparison = Integer.compare(this.age, o.age);
            if (ageComparison != 0) {
                return ageComparison; // If ages are different, return the result
            }
            // If ages are equal, compare by name
            return this.name.compareTo(o.name);
        }
    }
}