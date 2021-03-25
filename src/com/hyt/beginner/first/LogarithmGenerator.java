package com.hyt.beginner.first;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author houyutao
 * @date 2021-01-28
 */
public class LogarithmGenerator implements FirstClass {

    public static List<Integer> getNumbers(int maxNumber, int count) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
           list.add((int) (Math.random() * maxNumber));
        }

        return list;
    }

    public static void main(String[] args) {

        AtomicInteger count1 = new AtomicInteger();
        AtomicInteger count2 = new AtomicInteger();
        List<Integer> numbers = getNumbers(100000, 100000);
        numbers.forEach(o -> {
            if (o < 50000) {
                count1.getAndIncrement();
            } else {
                count2.getAndIncrement();
            }
        });


        System.out.println(count1.get());
        System.out.println(count2.get());
    }
}
