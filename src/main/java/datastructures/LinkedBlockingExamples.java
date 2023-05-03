package datastructures;

import java.util.concurrent.*;

public class LinkedBlockingExamples {
    public static void main(String... args)
            throws InterruptedException {
        LinkedBlockingDeque d;
        long time = System.currentTimeMillis();
        try {
//            ExecutorService pool = Executors.newFixedThreadPool(10);
            // When we inline above newFixedThreadPool method, we see that it uses LinkedBlockingQueue which takes quite a while
            // replace with LinkedBlockingDeque
            // replace with ArrayBlockingQueue with size 10_000_000 gives even faster results
            // LinkedTransferQueue is even faster

            // LinkedBlockingQueue uses re-enterant lock.
            // Creating 10_000_000 Threads using new Thread() would take 100 times more time, so this ExecutorService is more performant
            ExecutorService pool = new ThreadPoolExecutor(10, 10,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());
//            ExecutorService pool = Executors.newWorkStealingPool(10); // This is better for smaller jobs than most above queues
            for (int i = 0; i < 10_000_000; i++) {
                pool.submit(() -> {
                });
            }
            pool.shutdown();
            while (!pool.awaitTermination(1, TimeUnit.SECONDS)) ;
        } finally {
            time = System.currentTimeMillis() - time;
            System.out.println("time = " + time + "ms");
        }
    }
}
