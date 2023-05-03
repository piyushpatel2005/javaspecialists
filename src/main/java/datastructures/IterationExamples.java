package datastructures;

import java.util.*;

public class IterationExamples {
    public static void main(String... args) {
        // List cannot be modified while iterating.
        // This is solved using CopyOnWriteArrayList which keeps reference of original list but creates new one on the go.
        ArrayList<String> names = new ArrayList<>(
                Arrays.asList("John", "Anton", "Heinz"));
        names.forEach(name -> {
            if (name.contains("o")) names.remove(name);
        });
        System.out.println("names = " + names);
        names.listIterator(); //Erich Gamma et al - Design patterns
    }
}
