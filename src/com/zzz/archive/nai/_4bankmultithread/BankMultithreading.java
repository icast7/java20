package com.zzz.archive.nai._4bankmultithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankMultithreading {

    public static void main(String[] args) {
        BankThreadSafe bankThreadSafe = new BankThreadSafe();
        bankThreadSafe.accounts.putIfAbsent("hello", 0);
        bankThreadSafe.deposit("hello", 10);
        bankThreadSafe.withdraw("hello", 5);
        System.out.println("Done.");
    }

    static class Bank {
        // Singleton implementation omitted for brevity's sake

        // map from account number to balance
        private Map<String, Integer> accounts = new HashMap<>();

        public int deposit(String account, int sum) throws IllegalArgumentException {
            if (sum < 0) {
                throw new IllegalArgumentException("sum cannot be negative");
            }
            return accounts.put(account, accounts.get(account) + sum);
        }

        public int withdraw(String account, int sum) {
            if (sum > accounts.get(account)) {
                return -1;
            }
            accounts.put(account, accounts.get(account) - sum);
            return sum;
        }
    }

    static class BankThreadSafe {
        // Singleton implementation omitted for brevity's sake
        // map from account number to balance
        private Map<String, Integer> accounts = new ConcurrentHashMap<>();

        public int deposit(String account, int sum) throws IllegalArgumentException {
            if (sum < 0) {
                throw new IllegalArgumentException("sum cannot be negative");
            }
            synchronized (account) {
                return accounts.put(account, accounts.get(account) + sum);
            }
        }

        public int withdraw(String account, int sum) {
            synchronized (account) {
                if (sum > accounts.get(account)) {
                    return -1;
                }
                accounts.put(account, accounts.get(account) - sum);
                return sum;
            }
        }
    }
}
