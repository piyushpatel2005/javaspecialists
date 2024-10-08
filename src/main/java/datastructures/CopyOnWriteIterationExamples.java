package datastructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteIterationExamples {
    public static void main(String... args) {
        List<String> names = new CopyOnWriteArrayList<>(
                Arrays.asList("John", "Anton", "Heinz"));
        Collections.sort(names);
        System.out.println("names = " + names);
        for (Iterator<String> it = names.iterator(); it.hasNext(); ) {
            String name = it.next();
            System.out.println("Checking: " + name);
            if (name.contains("o")) names.remove(name);
        }
        System.out.println("names = " + names);
    }
}
