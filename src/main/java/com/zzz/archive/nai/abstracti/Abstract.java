package com.zzz.archive.nai.abstracti;

public abstract class Abstract {
    String color;

    public Abstract(String color) {
        this.color = color;
        Math.pow(1,2);
    }

    abstract float add(int a, int b);
    abstract float add(int a, int b, int c);

    public abstract double test();

    abstract boolean pandita();

    protected abstract String draw();
}