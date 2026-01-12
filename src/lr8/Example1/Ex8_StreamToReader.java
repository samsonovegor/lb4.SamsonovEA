package lr8.Example1;

import java.io.*;

public class Ex8_StreamToReader {
    public static void main(String[] args) throws Exception {

        Reader r = new InputStreamReader(
                new FileInputStream("E:\\MyFile1.txt"), "cp1251");

        int c;
        while ((c = r.read()) != -1)
            System.out.print((char) c);

        r.close();
    }
}
