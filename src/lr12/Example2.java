package lr12;

public class Example2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Число: " + i);
                try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
            }
        });

        t.start();
        t.join();
    }
}
