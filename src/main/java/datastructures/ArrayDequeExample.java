package datastructures;

import java.util.*;

public class ArrayDequeExample {
    public static void main(String... args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(1);
        ad.add(2);
        ad.add(3);
        ad.offer(3);
        ad.poll();
        ad.peek();
        ad.remove();
//    ad.element(); // throws

        for (int i = 0; i < 10_000; i++) {
            ad.add(i);
        }
        System.out.println(ad);

        ad.clear();
        // ArrayDeque seems to increase in size but doesn't decrease when elements are removed.

        System.out.println(ad);
    }
}
