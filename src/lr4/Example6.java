package lr4;

import java.util.Random;

public class Example6 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(10);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int row = rnd.nextInt(4);
        int col = rnd.nextInt(4);
        System.out.println();
        int[][] res = new int[3][3];
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (j == col) continue;
                res[r][c++] = arr[i][j];
            }
            r++;
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
