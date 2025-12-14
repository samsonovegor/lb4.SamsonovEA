package lr3;

public class Example8 {
    public static void main(String[] args) {

        char[] arr = new char[10];

        char ch = 'A';
        int index = 0;

        while (index < arr.length) {
            if (ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U') {
                arr[index] = ch;
                index++;
            }
            ch++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
