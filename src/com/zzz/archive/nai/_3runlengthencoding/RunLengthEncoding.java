package com.zzz.archive.nai._3runlengthencoding;

import java.util.Scanner;

public class RunLengthEncoding {
    public static void main(String[] args) {
        System.out.println("Enter word:");
        Scanner scanner = new Scanner(System.in);
        String plain  = scanner.nextLine();

        StringBuilder dest = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            int runLength = 1;
            while (i+1 < plain.length() && plain.charAt(i) == plain.charAt(i+1)) {
                runLength++;
                i++;
            }
            dest.append(runLength);
            dest.append(plain.charAt(i));
        }
        System.out.println(dest.toString());

    }
}
