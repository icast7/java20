package com.zzz.archive.nai._ddd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HourGlass {


    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] coord = {{0,0}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,2}};
        int max = Integer.MIN_VALUE;
        for (int y = 0; y < arr.length-2 ; y++) {
            System.out.println("xArray: " + Arrays.toString(arr[y]));
            for (int x =0; x < arr[y].length-2; x++) {
                int local = 0;
                for (int z = 0; z < coord.length; z++) {
                    int yAxis = coord[z][1] + y;
                    int xAxis = coord[z][0] + x;
                    local += arr[yAxis][xAxis];
                }
                max = local > max ? local : max;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

