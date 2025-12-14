package lr3;

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите два числа:");
        int a = in.nextInt();
        int b = in.nextInt();

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }

        in.close();
    }
}