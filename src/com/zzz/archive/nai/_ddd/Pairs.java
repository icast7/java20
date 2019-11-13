package com.zzz.archive.nai._ddd;

import java.io.*;
import java.util.*;

public class Pairs {
    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int i = 0, j = 1, count = 0;
        while (j < arr.length) {
            int delta = arr[j] - arr[i];
            if (delta == k) {
                count++;
                j++;
            } else if (delta > k) {
                i++;
            } else if (delta < k) {
                j++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

//        for (int i =0; i < arr.length; i++) {
//        for (int y = 0; y < arr.length; y++) {
//        int a = arr[i];
//        int b = arr[y];
//        int c = a - b;
//
//        if (c == k && !(pairs.contains(a+","+b) && pairs.contains(b+","+c))) {
//        pairs.add(a+","+b);
//        pairs.add(b+","+a);
//        counter++;
//        }
//        }
//        }
//        System.out.println(counter);
//        return counter;