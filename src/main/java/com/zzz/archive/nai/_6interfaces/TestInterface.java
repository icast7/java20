package com.zzz.archive.nai._6interfaces;

interface TestInterface {
    public void square(int a);

    default void show() {
        System.out.println("Default method executed.");
    }

    static void staticShow(){
        System.out.println("Static method executed.");
    }
}
