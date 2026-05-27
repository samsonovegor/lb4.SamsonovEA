package lr1;
import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число: ");
        int x = in.nextInt();

        int before = x - 1;
        int after = x + 1;
        int square = (before + x + after) * (before + x + after);

        System.out.println(before + ", " + x + ", " + after + ", " + square);

        in.close();
    }
}