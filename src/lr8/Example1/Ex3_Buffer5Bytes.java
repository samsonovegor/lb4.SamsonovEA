package lr8.Example1;

import java.io.*;

public class Ex3_Buffer5Bytes {
    public static void main(String[] args) throws Exception {
        BufferedInputStream bis =
                new BufferedInputStream(
                        new FileInputStream("E:\\MyFile1.txt"), 5);

        int b;
        while ((b = bis.read()) != -1)
            System.out.print((char) b);

        bis.close();
    }
}
