package datastructures;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class SortingExample {
    public static void main(String[] args) {
        // List comparison below uses natural sorting order
//        List<String> names = Arrays.asList("John", "Anton", "Heinz");
//        names.sort(null);

        List<Student> names = Arrays.asList(
                new Student(1, "John", 56.0),
                new Student(2, "John", 86.0),
                new Student(3, "Heinz", 72.0),
                new Student(3, "Anton", 56.0)
        );
        names.sort(null); // This works because Student implements Comparable which has ordering defined.
        // If I want to sort by different oder, previously we used to do like this.
        System.out.println(names);
        names.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int result = s1.getName().compareTo(s2.getName());
                return result != 0 ? result: Integer.compare(s1.getYear(), s2.getYear());
            }
        });
        System.out.println(names);

        // by grade comparison
        names.sort((s1, s2) -> {
            int result = Double.compare(s1.getAverage(), s2.getAverage());
            if (result == 0) {
                result = s1.getName().compareTo(s2.getName());
            }
            if (result == 0) {
                result = Integer.compare(s1.getYear(), s2.getYear());
            }
            return result;
        });
        System.out.println(names);

        // better way
        names.sort(
//                Comparator.comparingDouble((Student s) -> s.getAverage())
//                .thenComparing(s -> s.getName())
//                .thenComparingInt(s -> s.getYear())

//                Comparator.<Student>comparingDouble(s -> s.getAverage())
//                        .thenComparing(s -> s.getName())
//                        .thenComparingInt(s -> s.getYear())

                Comparator.comparingDouble(Student::getAverage)
                        .reversed() // we can reverse only on average so that highest average student is first.
                .thenComparing(Student::getName)
                .thenComparingInt(Student::getYear)
        );
        System.out.println(names);


        List<Integer> numbers = fillWithLotsOfRandomValues();

        for (int i = 0; i < 5; i++) {
            testSortingSpeed(numbers);
        }
        testSortingSpeed(numbers);
    }

    private static void testSortingSpeed(List<Integer> numbers) {
        List<Integer> arrayList = new ArrayList<>(numbers);
        List<Integer> linkedList = new LinkedList<>(numbers);
        List<Integer> parallelSortingArrayList = new ParallelSortingArrayList<>(numbers);

        sortList(arrayList);
        sortList(linkedList);
        sortList(parallelSortingArrayList);
        System.out.println("After already being sorted");
        for (int i = 0; i < 5; i++) {
            sortList(arrayList);
            sortList(linkedList);
            sortList(parallelSortingArrayList);
        }
    }

    private static void sortList(List<Integer> list) {
        long time = System.currentTimeMillis();
        list.sort(null);
        time = System.currentTimeMillis() - time;
        System.out.println(list.getClass().getSimpleName() + " time = " + time);
    }

    private static List<Integer> fillWithLotsOfRandomValues() {
        return ThreadLocalRandom.current().ints(10_000_000).parallel().boxed()
                .collect(Collectors.toList());
    }
}
