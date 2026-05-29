package lr12;

public class Example3 {

    static final Object lock = new Object();
    static int number = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread evenThread = new Thread(() -> {
            while (number <= 10) {
                synchronized (lock) {
                    while (number <= 10 && number % 2 != 0) {
                        try { lock.wait(); } catch (InterruptedException e) { return; }
                    }
                    if (number <= 10) {
                        System.out.println("Чётный поток: " + number);
                        number++;
                        lock.notifyAll();
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            while (number <= 10) {
                synchronized (lock) {
                    while (number <= 10 && number % 2 == 0) {
                        try { lock.wait(); } catch (InterruptedException e) { return; }
                    }
                    if (number <= 10) {
                        System.out.println("Нечётный поток: " + number);
                        number++;
                        lock.notifyAll();
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
        oddThread.join();
        evenThread.join();
    }
}
