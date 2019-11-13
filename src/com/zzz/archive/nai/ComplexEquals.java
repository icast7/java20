package com.zzz.archive.nai;

import java.util.*;

public class ComplexEquals {
    private double re, im;

    public ComplexEquals(double re, double im){
        this.re = re;
        this.im = im;
    }

    public static void main(String[] args) {
        ComplexEquals c1 = new ComplexEquals(10, 15);
        ComplexEquals c2 = new ComplexEquals(10, 15);
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        if (c1.equals(c2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }

        String[] hello = {"w","o","r","l","d"};
        for (String x: hello) {
            System.out.println(x);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ComplexEquals)){
            return false;
        }

        List a = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        List x = new LinkedList<Integer>(List.of(1,2,3,4,5));

        ComplexEquals ce = (ComplexEquals) o;
        return Double.compare(ce.re, re) == 0
            && Double.compare(ce.im, im) == 0;
    }
}
