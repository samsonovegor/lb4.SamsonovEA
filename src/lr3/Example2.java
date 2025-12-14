package lr3;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название дня недели:");
        String day = in.nextLine().toLowerCase();
        int number;
        switch (day) {
            case "понедельник": number = 1; break;
            case "вторник": number = 2; break;
            case "среда": number = 3; break;
            case "четверг": number = 4; break;
            case "пятница": number = 5; break;
            case "суббота": number = 6; break;
            case "воскресенье": number = 7; break;
            default: number = -1;
        }
        if (number == -1)
            System.out.println("Такого дня нет");
        else
            System.out.println(number);
        in.close();
    }
}
