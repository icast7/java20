package com.zzz.archive.nai._8arrayShuffle;

import java.util.Random;
import java.util.Scanner;

public class FisherYatesShuffle {
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Enter things:::");
        String word = new Scanner(System.in).nextLine();
        Character[] newarray = new Character[word.length()];

        char[] oldArray = word.toCharArray();
        for(int i=0; i < word.length(); i++) {
            newarray[i] = oldArray[i];
        }

        shuffle(newarray);
    }

    public static <T> void shuffle(T[] array){
        for (int i=0; i < array.length; i++) {
            int j = i + random.nextInt(array.length - i);
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        for (T t: array) {
            System.out.println(t);
        }
    }
}
