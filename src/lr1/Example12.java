package lr1;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите возраст: ");
        int age = in.nextInt();

        int birthYear = 2025 - age;

        System.out.println("Год рождения: " + birthYear);

        in.close();
    }
}