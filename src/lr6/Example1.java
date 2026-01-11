package lr6;

public class Example1 {

    char ch;
    String text;
    void setValue(char c) {
        ch = c;
    }
    void setValue(String s) {
        text = s;
    }
    void setValue(char[] arr) {
        if (arr.length == 1) {
            ch = arr[0];
        } else {
            text = new String(arr);
        }
    }
}
