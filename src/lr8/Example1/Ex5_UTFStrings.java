package lr8.Example1;

import java.io.*;
import java.util.Scanner;

public class Ex5_UTFStrings {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        File f = new File("text.txt");

        DataOutputStream out =
                new DataOutputStream(new FileOutputStream(f));

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++)
            out.writeUTF(sc.nextLine());

        out.close();
    }
}
