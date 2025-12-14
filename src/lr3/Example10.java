package lr3;

import java.util.Random;
import java.util.Arrays;

public class Example10 {
    public static void main(String[] args) {

        Random rnd = new Random();

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100);
            System.out.println(arr[i]);
        }

        Arrays.sort(arr);

        System.out.println("После сортировки по убыванию:");

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
