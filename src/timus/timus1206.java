package timus;

import java.math.BigInteger;
import java.util.Scanner;

public class timus1206 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        BigInteger ans =
                BigInteger.valueOf(36)
                        .multiply(BigInteger.valueOf(55).pow(k - 1));

        System.out.println(ans);
    }
}
