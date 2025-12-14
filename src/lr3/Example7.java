package lr3;

public class Example7 {
    public static void main(String[] args) {

        char[] arr = new char[10];
        char ch = 'a';

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ch;
            ch += 2;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
