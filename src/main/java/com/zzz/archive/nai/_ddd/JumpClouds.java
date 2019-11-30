package com.zzz.archive.nai._ddd;

import java.io.*;
import java.util.*;

public class JumpClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int steps = 0 ;
        int index = 0;
        do {
            if (index+2 < c.length && c[index + 2] == 0) {
                index+= 2;
                steps++;
            } else if (index+1 < c.length && c[index + 1] == 0) {
                index++;
                steps++;
            }
            if (index == c.length-1) {
                break;
            }
        } while (index < c.length);
        System.out.println(steps);
        return steps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
