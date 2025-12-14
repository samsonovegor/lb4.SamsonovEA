package lr3;

import java.util.Random;

public class Example9 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100);
            System.out.println(arr[i]);
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("Минимум: " + min);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) System.out.println("Индекс: " + i);
        }
    }
}
