package datastructures;

import java.util.List;
import java.util.RandomAccess;

public class ListExamples {
    public static void main(String... args) {
        // List.of creates an immutable List whereas Arrays.asList even though cannot be added, those elements can be modified in place.
        List<String> names = List.of("John", "Anton"); // Java 9

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        System.out.println(names);

        RandomAccess ra;

//    names.set(1, "Antony");
//
//    System.out.println(names);

//    names.add("Dirk");
//    names.clear();
    }
}
