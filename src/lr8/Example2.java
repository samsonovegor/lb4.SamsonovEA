package lr8;

import java.io.*;

public class Example2 {
    public static void main(String[] args) {

        try {
            //Создание исходного файла
            DataOutputStream out =
                    new DataOutputStream(new FileOutputStream("source.dat"));

            out.writeUTF("Первая строка");
            out.writeUTF("Вторая строка");
            out.writeDouble(3.5);
            out.writeDouble(-2.1);
            out.writeDouble(7.8);
            out.writeDouble(-4.0);
            out.writeDouble(1.2);
            out.close();

            //Чтение и фильтрация
            DataInputStream in =
                    new DataInputStream(new FileInputStream("source.dat"));

            PrintWriter pw =
                    new PrintWriter("result.txt", "UTF-8");

            in.readUTF();              //пропуск первой строки
            pw.println(in.readUTF());  //запись второй строки

            for (int i = 0; i < 5; i++) {
                double x = in.readDouble();
                if (x > 0) {
                    pw.println(x);
                }
            }

            in.close();
            pw.close();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
