package lr12;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " +
                    LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
            }
        }, "Поток-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " +
                    LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
            }
        }, "Поток-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
