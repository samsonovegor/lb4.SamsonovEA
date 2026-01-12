package lr8.Example1;

import java.io.File;

public class Ex1_FileCreate {
    public static void main(String[] args) {
        try {
            File f1 = new File("MyFile1.txt");
            f1.createNewFile();

            File f2 = new File("E:\\MyFile2.txt");
            f2.createNewFile();

            File f3 = new File("E:\\Papka1\\Papka2\\Papka3");
            f3.mkdirs();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
