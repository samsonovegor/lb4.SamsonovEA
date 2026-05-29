package lr12;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Example5 {

    public static void main(String[] args) throws InterruptedException {
        int[] array = {5, 3, 8, 1, 9, 2, 7, 4, 6, 10, 15, 11, 3, 14, 12};
        System.out.println("Массив: " + java.util.Arrays.toString(array));
        System.out.println("Максимум: " + findMax(array));
    }

    static int findMax(int[] array) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество потоков: " + cores);

        AtomicInteger globalMax = new AtomicInteger(Integer.MIN_VALUE);
        int chunkSize = (int) Math.ceil((double) array.length / cores);
        Thread[] threads = new Thread[cores];

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            if (start >= array.length) break;

            threads[i] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > localMax) localMax = array[j];
                }
                final int lm = localMax;
                globalMax.updateAndGet(cur -> Math.max(cur, lm));
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            if (t != null) t.join();
        }

        return globalMax.get();
    }
}
