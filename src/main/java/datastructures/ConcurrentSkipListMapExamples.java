package datastructures;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

// Use ConcurrentSkipListMap to have elements in sorted order and thread-safety
// Use ConcurrentHashMap only for thread-safety
// HashMap for non-threadsafe, not sorted
// TreeMap for non-threadsafe, sorted
public class ConcurrentSkipListMapExamples {
    public static void main(String... args) {
//        Map<Integer, Integer> squares = new HashMap<>();
//        Map<Integer, Integer> squares = new TreeMap<>();
        Map<Integer, Integer> squares = new ConcurrentHashMap<>();
        IntStream.range(0, 10_000).parallel().forEach(
                i -> squares.put(i, i*i)
        );
        System.out.println("squares = " + squares);
        System.out.println("squares.size() = " + squares.size());

    }
}
