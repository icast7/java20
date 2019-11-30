package com.zzz.archive.nai.java67;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter an integer:");
        int number = new Scanner(System.in).nextInt();
        System.out.println("Fibonacci series up to:" + number + " numbers:");

        for (int i = 1; i <= number; i++) {
            System.out.println(fibonacci(i) + " ");
        }
        System.out.println("--- --- --- ---");
        for (int i = 1; i <= number; i++) {
            System.out.println(fibonacci2(i) + " ");
        }
    }

    private static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    private static int fibonacci2(int number) {
        if (number == 1 || number ==2) {
            return 1;
        }
        int fibo1 = 1, fibo2 = 1, fibonacci = 1;
        for (int i = 3; i <= number; i++) {
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
    }
}
