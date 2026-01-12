package lr8.Example1;

import java.io.*;
import java.util.Scanner;

public class Ex4_DataStreams {
    public static void main(String[] args) throws Exception {

        File dir = new File("E:\\My");
        dir.mkdir();

        File f1 = new File(dir, "numIsh.txt");
        File f2 = new File(dir, "numRez.txt");

        Scanner sc = new Scanner(System.in);

        DataOutputStream out =
                new DataOutputStream(new FileOutputStream(f1));

        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            out.writeDouble(sc.nextDouble());
        out.close();

        DataInputStream in =
                new DataInputStream(new FileInputStream(f1));

        out = new DataOutputStream(new FileOutputStream(f2));

        try {
            while (true) {
                double x = in.readDouble();
                out.writeDouble(x);
            }
        } catch (EOFException ignored) {}

        in.close();
        out.close();
    }
}
