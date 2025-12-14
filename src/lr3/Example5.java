package lr3;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество чисел:");
        int n = in.nextInt();
        int count = 0;
        int num = 1;
        int sum = 0;
        while (count < n) {
            if (num % 5 == 2 || num % 3 == 1) {
                System.out.println(num);
                sum += num;
                count++;
            }
            num++;
        }
        System.out.println("Сумма = " + sum);
        in.close();
    }
}
