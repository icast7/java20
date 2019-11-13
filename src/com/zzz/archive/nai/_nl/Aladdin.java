package com.zzz.archive.nai._nl;

import java.util.ArrayList;
import java.util.List;

public class Aladdin {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        list1.add(5);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(2);
        optimalPoint(list1, list2);
    }


    public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
        int result = -1;
        for (int minIndex=0; minIndex < magic.size(); minIndex++) {
            // Write your code here
            int fuel = 0;
            int prevDistance = 0;
            int totalDistance = 0;
            int index = 0;
            boolean fullRide = false;
            do {
                if (fuel >= prevDistance) {
                    totalDistance += prevDistance;
                    if (totalDistance >= magic.size()) {
                        fullRide = true;
                    }
                    int newFuel = magic.get(index);
                    fuel += newFuel - prevDistance;
                    prevDistance = dist.get(index);
                    index = prevDistance - 1;
                } else {
                    break;
                }
            } while (!fullRide);
            result = fullRide ? minIndex : result;
            break;
        }
        System.out.println(result);
        return result;
    }
}
