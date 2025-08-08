package org.example.easyconcurrency;


//Thread Safe by Synchronized Keyword
public class CounterV2 {

    private int count = 0;



    public synchronized void increment() {
        count++;
    }


    public synchronized int get() {
        return count;
    }

}
