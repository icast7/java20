package com.zzz.archive.nai._8arrayShuffle;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayShuffler<T> {
    private T[] array;
    private AtomicInteger index;
    private Semaphore semaphore;

    public ArrayShuffler(T[] array){
        this.array = array;
        index = new AtomicInteger(0);
        semaphore = new Semaphore(0);
    }

    public void startShuffling() {
        Random random = new Random();
        for (int source = 0; source < array.length; ++source) {
//            System.out.println(source);
            int target = random.nextInt(array.length - source) + source;
            T temp = array[source];
            array[source] = array[target];
            array[target] = temp;
            semaphore.release();
        }
    }

    public T getNext() throws InterruptedException {
        semaphore.acquire();
        int i = index.getAndIncrement();
        return array[i];
    }
}
