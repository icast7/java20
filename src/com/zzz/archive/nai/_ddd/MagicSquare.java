package com.zzz.archive.nai._ddd;

import java.io.*;
import java.util.*;

public class MagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int finalCost = Integer.MAX_VALUE;
        int t[][] = {
                {4,9,2,3,5,7,8,1,6},
                {4,3,8,9,5,1,2,7,6},
                {2,9,4,7,5,3,6,1,8},
                {2,7,6,9,5,1,4,3,8},
                {8,1,6,3,5,7,4,9,2},
                {8,3,4,1,5,9,6,7,2},
                {6,7,2,1,5,9,8,3,4},
                {6,1,8,7,5,3,2,9,4}
        };

        int tempCost = 0;
        for (int i=0; i<8; i++) {
            int[] c = t[i];
            tempCost = Math.abs(s[0][0] - c[0]) +
                       Math.abs(s[0][1] - c[1]) +
                       Math.abs(s[0][2] - c[2]) +
                       Math.abs(s[1][0] - c[3]) +
                       Math.abs(s[1][1] - c[4]) +
                       Math.abs(s[1][2] - c[5]) +
                       Math.abs(s[2][0] - c[6]) +
                       Math.abs(s[2][1] - c[7]) +
                       Math.abs(s[2][2] - c[8]) ;

            finalCost = tempCost < finalCost ? tempCost : finalCost;
        }
        System.out.println(finalCost);
        return finalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
