package lr3;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int size = in.nextInt();

        int[] arr = new int[size];

        int x = 2;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = x;
            System.out.println(arr[i]);
            x += 5;
        }

        in.close();
    }
}
