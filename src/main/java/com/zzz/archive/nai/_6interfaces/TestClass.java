package com.zzz.archive.nai._6interfaces;

public class TestClass implements TestInterface, SecondInterface{
    @Override
    public void square(int a) {
        System.out.println(a*a);
    }

    public void square(Object a) {
        System.out.println((int)a * (int)a);
    }

    @Override
    public void show() {
        TestInterface.super.show();
        SecondInterface.super.show();
    }

    public static void main(String[] args) {
        TestClass d = new TestClass();
        d.square(5);
        d.show();
    }
}
