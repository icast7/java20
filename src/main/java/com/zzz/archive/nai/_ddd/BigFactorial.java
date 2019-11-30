package com.zzz.archive.nai._ddd;

import java.math.*;
import java.util.*;

public class BigFactorial {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger bigInteger = new BigInteger("1");
        for (int i = n; i > 0; i--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        Math.floorMod(1,1);
        System.out.println(bigInteger);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
