package com.zzz.archive.nai._8arrayShuffle;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Enter things:::");
        String word = new Scanner(System.in).nextLine();
        Character[] newarray = new Character[word.length()];

        char[] oldArray = word.toCharArray();
        for(int i=0; i < word.length(); i++) {
            newarray[i] = oldArray[i];
        }
        ArrayShuffler arrayShuffler = new ArrayShuffler(newarray);
        arrayShuffler.startShuffling();
    }
}
