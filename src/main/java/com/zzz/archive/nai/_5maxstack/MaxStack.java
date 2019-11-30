package com.zzz.archive.nai._5maxstack;

import java.util.Stack;

public class MaxStack<T extends Comparable<T>> extends Stack<T> {
    private T max;

    @Override
    public T push(T item) {
        if (max == null || item.compareTo(max) > 0) {
            max = item;
        }
        super.push(item);
        return item;
    }
}
