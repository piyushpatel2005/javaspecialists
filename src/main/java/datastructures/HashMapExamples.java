package datastructures;

import java.util.*;
import java.util.concurrent.*;

// This is not thread-safe, but widely used.
// For concurrent uses, use ConcurrentHashMap. In fact, this can be used everywhere because the memory difference compared to
// HashMap is quite minimal but we get thread-safety for free.
public class HashMapExamples {
    private static class Person { // For Java 8 and after it is advised to implement Comparable because HashMap stores clashes into Tree structure which gets better performance with Comparable
        private final String name;
        private final int day;
        private final int month;
        private final int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public int hashCode() {
            return (name.hashCode() << 16) ^ (day << 12) ^ (month << 8) ^ year; // java 1.4
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (day != person.day) return false;
            if (month != person.month) return false;
            if (year != person.year) return false;
            if (name != null ? !name.equals(person.name) : person.name != null) return false;

            return true;
        }
    }
    public static void main(String... args) {
        // 1.2 born - % remainder slow, but good distribution
        // 1.4 & bitmask fast, but can be bad distribution
        // 1.8 tree if too many clashes
        //HashMap 3816
        // ArrayList 5408 MapClashInspector Issue 235

        HashMap<String, Integer> numbers = new HashMap<>(
                Map.of("one", 1, "two", 2, "sixteen", 16, "unlucky", 13)); // can be used for only upto 10 key-value pairs
        Map<String, Integer> numbers2 = new HashMap<String, Integer>(
                Map.ofEntries(
                        Map.entry("one", 1),
                        Map.entry("two" ,2)
                )
        );
        System.out.println("numbers2 = " + numbers2);
        HashMap<String, List<Integer>> superstition = new HashMap<>();
        add(superstition, "unlucky", 13);
        add(superstition, "unlucky", 7);
        add(superstition, "unlucky", 3);
        add(superstition, "lucky", 65);
        add(superstition, "lucky", 60);
        add(superstition, "lucky", 5);

        superstition.forEach((k, v) -> System.out.println(k + "->" + v));

    }

    private static void add(HashMap<String, List<Integer>> superstition, String key, int number) {
        superstition.computeIfAbsent(key, k -> new ArrayList<>()).add(number);
    }
    
}
