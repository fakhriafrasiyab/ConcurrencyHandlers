package org.example.easyconcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterV3 {

    private final AtomicInteger count = new AtomicInteger(0);


    public void increment() {
        count.incrementAndGet();
    }

    public int get() {
        return count.get();
    }

}
