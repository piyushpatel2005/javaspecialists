package datastructures;

import java.util.*;

public class VectorExamples {
    // Do not use Vector, rather use ArrayList
    // For thread-safety which Vector is, use Collections.synchronizedList
    // Vectors grow 2 times in size so it may occupy unnecesary spaces than ArrayList which increases by 1.5 times
    public static void main(String... args) {
        Vector<String> names = new Vector<>(
                Arrays.asList("John", "Anton", "Heinz")
        );
        List<String> namesSafe = Collections.synchronizedList(
                new ArrayList<>(Arrays.asList("John", "Anton", "Heinz")));
    }
}
