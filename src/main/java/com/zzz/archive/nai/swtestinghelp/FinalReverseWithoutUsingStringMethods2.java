package com.zzz.archive.nai.swtestinghelp;

public class FinalReverseWithoutUsingStringMethods2 {
    public static void main(String[] args) {
        String str = "MySecondTest";
        char[] chars = str.toCharArray();
        StringBuilder a = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            a.append(chars[i]);
            System.out.print(chars[i]);
        }
        System.out.println();
        System.out.println(a);
    }
}