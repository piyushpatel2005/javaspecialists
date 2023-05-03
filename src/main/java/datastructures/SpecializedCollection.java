package datastructures;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class SpecializedCollection {
    public static void main(String... args) {
        // 27. Highly specialized collections:
        // EnumSet, EnumMap, IdentityHashMap,
        // Properties, WeakHashMap

        EnumSet<Thread.State> states = EnumSet.allOf(
                Thread.State.class);
        states.remove(Thread.State.RUNNABLE);
        System.out.println("states = " + states);

        Map<Thread.State, LongAdder> timesInState =
                Collections.synchronizedMap(
                        new EnumMap<>(Thread.State.class));


        // Not so useful, it uses identity of the object.
        IdentityHashMap<String, Integer> map =
                new IdentityHashMap<>();
        map.put("Hello", 42);
        System.out.println(map.get(new String("Hello"))); // even though equals returns true, == returns false for this, hence we get null

        // To implement IdentityHashMap without this built-in class, we can do below.
        Map<IdentityKey<String>, Integer> map2 =
                new ConcurrentHashMap<>();
        map2.put(new IdentityKey<>("Hello"), 42);
        System.out.println(map2.get(new IdentityKey(new String("Hello"))));

        // Alternatively, we can build thread-safe class by using synchronizedMap
        Map<String, Integer> map3 = Collections.synchronizedMap(map);

        WeakHashMap wm;
        // This is used for lookup. It used to be Hashtable, but now ConcurrentHashMap
        Properties prop = new Properties();
        int parallelism = Integer.parseInt(System.getProperty(
                "java.util.concurrent.ForkJoinPool.common.parallelism", "42"));
        // Better way to get system properties
        int parallelismBetter = Integer.getInteger(
                "java.util.concurrent.ForkJoinPool.common.parallelism", 42);
    }

    private static class IdentityKey<K> {
        private final K key;

        public IdentityKey(K key) {
            this.key = key;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return key == ((IdentityKey<?>) o).key;
        }

        public int hashCode() {
            return System.identityHashCode(key);
        }
    }
}
