package com.zzz.archive.nai._ddd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedStringSolution {
        // Complete the repeatedString function below.
        static long repeatedString(String s, long n) {
            int root = s.length() - s.replaceAll("a","").length();
            long howManyInRoot = (n / s.length()) * root;

            double charsLeft = n % s.length();
            String subString  = s.substring(0, (int) charsLeft);
            int howManyInSubString = subString.length() - subString.replaceAll("a", "").length();

            long total = howManyInRoot + howManyInSubString;
            System.out.println(total);
            return total;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

            String s = scanner.nextLine();

            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = repeatedString(s, n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }

}
