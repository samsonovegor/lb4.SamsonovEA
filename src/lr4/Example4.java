package lr4;

public class Example4 {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = 1;
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}