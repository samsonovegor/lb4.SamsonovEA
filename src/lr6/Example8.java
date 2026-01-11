package lr6;

public class Example8 {

    static double average(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return (double) sum / arr.length;
    }
}
