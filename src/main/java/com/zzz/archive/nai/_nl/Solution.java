package com.zzz.archive.nai._nl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        List<String> s = new ArrayList<>();
        s.add("Louis IX");
        s.add("Philippe II");



        sortRoman(s);
    }

    public static int convert(String r) {
        int value = 0;
        for(int n = 0; n < r.toCharArray().length; n ++) {
            char next = '\u0000';
            if (n + 1 < r.length()) {
                next = r.charAt(n+1);
            }
            switch (r.charAt(n)) {
                case 'I':
                    value += (next == 'V' || next =='X') ? -1 : 1;
                    break;
                case 'V':
                    value += 5;
                    break;
                case 'X':
                    value += next == 'L' ? -10 : 10;
                    break;
                case 'L':
                    value += 50;
                    break;
                default:
                    break;
            }
        }
        return value;
    }

    public static List<String> sortRoman(List<String> names) {
        List<String> result = new ArrayList<>();
        HashMap<String,String> hm = new HashMap<String, String>();
        String[] array =  new String[names.size()];
        for (int x = 0; x < names.size(); x++) {
            String[] split = names.get(x).split(" ");
            String number = String.format("%02d", convert(split[1]));
            System.out.println(number+ split[0]);
            array[x] = split[0]+number;
            hm.put(split[0]+number, names.get(x));
        }
        Arrays.sort(array);
        for (String n : array) {
            result.add(hm.get(n));
        }
        return result;
    }

}
