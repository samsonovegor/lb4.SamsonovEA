package lr8;

import java.io.*;

public class Example2 {
    public static void main(String[] args) throws Exception {

        DataInputStream in = new DataInputStream(
                new FileInputStream("source.dat"));

        PrintWriter out = new PrintWriter("result.txt");

        String first = in.readUTF();
        String second = in.readUTF();
        out.println(second);

        for (int i = 0; i < 5; i++) {
            double x = in.readDouble();
            if (x > 0) out.println(x);
        }

        in.close();
        out.close();
    }
}
