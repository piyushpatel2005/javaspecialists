package datastructures;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentSkipListSetExamples {
    // This class is thread-safe but very less used and hence likely to have some bugs in it.
    // This also keeps the elements sorted and keeps pointers to the middle of the elements so that if we have to find
    // the middle element, it can get it quickly rather than traversing to the middle and getting the element.
    public static void main(String... args) {
        ConcurrentSkipListSet<Integer> numbers =
                new ConcurrentSkipListSet<>(Collections.reverseOrder());
        ThreadLocalRandom.current().ints(100).forEach(numbers::add);
        System.out.println("numbers.size() = " + numbers.size());
        System.out.println("numbers = " + numbers);
    }
}
