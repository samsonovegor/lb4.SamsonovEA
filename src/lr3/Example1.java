package lr3;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число от 1 до 7:");
        int day = in.nextInt();
        String name;
        switch (day) {
            case 1: name = "Понедельник"; break;
            case 2: name = "Вторник"; break;
            case 3: name = "Среда"; break;
            case 4: name = "Четверг"; break;
            case 5: name = "Пятница"; break;
            case 6: name = "Суббота"; break;
            case 7: name = "Воскресенье"; break;
            default: name = "Некорректное значение!";
        }
        System.out.println(name);
        in.close();
    }
}
