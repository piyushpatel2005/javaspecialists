package datastructures;

public class ComputationalTimeComplexity {
    volatile static int value;

    public static void main(String[] args) {

        value = 42; // O(1)

        // linear complexity
        for (int n = 100_000_000; n < 1_600_000_000; n *= 2)
            linearComplexity(n);

        // quadratic time
        for (int i = 1_000; i < 100_000 && i > 0; i *= 2) {
            quadraticComplexity(i);
        }

        for (long n = 1_000_000_000L; n < 1_000_000_000_000L; n++) {
            logarithmicComplexity(n);
        }

    }

    private static void linearComplexity(int n) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            value = i;
        }
        time = System.currentTimeMillis() - time;
        System.out.println(n + ": time = " + time);
    }

    private static void quadraticComplexity(int n) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                value = j;
            }
        }
        time = System.currentTimeMillis() - time;
        System.out.println(n + ": time = " + time);
    }

    private static void logarithmicComplexity(long n) {
        int steps = 0;
        long time = System.currentTimeMillis();
        for (long i = 1; i < n; i *= 2) {
            value = (int) i;
            steps++;
        }
        time = System.currentTimeMillis() - time;
        System.out.println(n + ": time = " + time + " steps = " + steps);
    }

}
