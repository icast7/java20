package com.zzz.archive.nai.swtestinghelp;


public class FinalReverseWithoutUsingStringMethods{
    public static void main(String[] args) {
        String str = "MyFirstTest";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder = stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}