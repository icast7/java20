package com.zzz.archive.nai._5maxstack;

import java.util.Stack;

public class MaxStackAdv<T extends Comparable<T>> extends Stack<T> {
    private final Stack<T> maxs = new Stack<T>();

    private T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    @Override
    public T push(T item) {
        if (maxs.empty()) {
            return maxs.push(item);
        } else {
            return maxs.push(max(max(), item));
        }
    }

    @Override
    public T pop(){
     maxs.pop();
     return super.pop();
    }

    public T max() {
        return maxs.peek();
    }
}
