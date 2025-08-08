package org.example;


// Not Thread-Safe version
public class CounterV1 {

    private int count = 0;

    public void increment() {
        count++;
    }

    public int get() {
        return count;
    }





}
