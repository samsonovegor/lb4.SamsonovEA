package lr12;

import java.util.concurrent.atomic.AtomicLong;

public class Example6 {

    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Массив: " + java.util.Arrays.toString(array));
        System.out.println("Сумма: " + sum(array));
    }

    static long sum(int[] array) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество потоков: " + cores);

        AtomicLong total = new AtomicLong(0);
        int chunkSize = (int) Math.ceil((double) array.length / cores);
        Thread[] threads = new Thread[cores];

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            if (start >= array.length) break;

            threads[i] = new Thread(() -> {
                long localSum = 0;
                for (int j = start; j < end; j++) localSum += array[j];
                total.addAndGet(localSum);
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            if (t != null) t.join();
        }

        return total.get();
    }
}
