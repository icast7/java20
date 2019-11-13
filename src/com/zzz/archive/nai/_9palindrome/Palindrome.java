package com.zzz.archive.nai._9palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter word:");
        String word = new Scanner(System.in).nextLine();
        System.out.println(String.format("Is it? %s", isPalindrome(word)));

        System.out.println("Has palindrome permutation:");
        System.out.println(hasPalindromePermutation(word));
    }

    public static boolean isPalindrome(String palindrome) {
        if (palindrome != null || !palindrome.isBlank()) {

            int n = palindrome.length();
            for (int i = 0; i < n / 2; i++) {
                if (palindrome.charAt(i) != palindrome.charAt(n - 1 - i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

//    public static boolean hasPalindromePermutationStream(String string) {
//        return string.chars()
//                .boxed().allMatch()
//    }

    public static boolean hasPalindromePermutation(String string) {
        Map<Character, Integer> counts = new HashMap<>();
        for (Character c : string.toCharArray()) {
            if (!counts.containsKey(c)) {
                counts.put(c, 0);
            }
            counts.put(c, counts.get(c) + 1);
        }
        int oddCount = 0;
        for(Integer count : counts.values()) {
         if (count % 2 == 1) {
             oddCount++;
             if (oddCount > 1){
                 return  false;
             }
         }
        }
        return true;
    }
}
