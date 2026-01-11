package lr6;

public class Example6 {

    static int[] subArray(int[] arr, int n) {
        if (n >= arr.length) {
            return arr.clone();
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
