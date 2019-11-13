package com.zzz.archive.nai._ddd;

import java.io.*;
import java.util.*;

public class SolutionValley {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;
        boolean wasPreviousSeaLevel = false;
        for(int i = 0; i < s.length(); i++) {
            if ( level < 0 ) {
                wasPreviousSeaLevel = true;
            }
            char c = s.charAt(i);
            if (c=='U') {
                level ++;
                if (level == 0 && wasPreviousSeaLevel) {
                    valleys++;
                }
            } else if(c == 'D'){
                level --;
            }
        }
        System.out.println(valleys);
        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hello.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}