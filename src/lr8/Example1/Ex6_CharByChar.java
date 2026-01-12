package lr8.Example1;

import java.io.*;

public class Ex6_CharByChar {
    public static void main(String[] args) throws Exception {

        FileReader in = new FileReader("E:\\MyFile1.txt");
        FileWriter out = new FileWriter("E:\\MyFile2.txt", true);

        int c;
        while ((c = in.read()) != -1)
            out.append((char) c);

        in.close();
        out.close();
    }
}
