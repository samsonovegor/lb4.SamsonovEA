package lr1;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите фамилию: ");
        String last = in.nextLine();

        System.out.println("Введите имя: ");
        String first = in.nextLine();

        System.out.println("Введите отчество: ");
        String middle = in.nextLine();

        System.out.println("Hello " + last + " " + first + " " + middle);

        in.close();
    }
}