package datastructures;

import java.util.*;

public class HashtableExamples {
    public static class Person {
        private final String name;

        public Person(String name) {
            this.name = name;
        }

        public int hashCode() {
            return 1;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Person)) return false;
            System.out.println("equals(" + ((Person)obj).name + ")");
            return name.equals(((Person)obj).name);
        }
    }

    public static void main(String... args) {
        Map<Person, Object> map = new Hashtable<>();
        map.put(new Person("Heinz"), "dummy");
//        map.put(null, null); // strangely HashMap allows inserting null values which breaks putIfAbsent method
        System.out.println(map);
        System.out.println(map.get(new Person("John"))); // while getting it calls equals method, HashMap and Hashtable have different equals method
        // one calling on incoming object and one calling on existing objects.
//        map.putIfAbsent(null, "oopsie");
        System.out.println("map = " + map);
    }
}

