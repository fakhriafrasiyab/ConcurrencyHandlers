package org.example;


public class App {
    public static void main(String[] args) throws InterruptedException {
        //with first version everytime different results
        CounterV1 counterV1 = new CounterV1();
        int numThreads = 10;
        int incrementsPerThread = 1000;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counterV1.increment();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final counter value: " + counterV1.get());
        // Expected: 10000 -- but different


        //v2 by synchronized
        CounterV2 counterV2 = new CounterV2();
        int numThreads2 = 10;
        int incrementsPerThread2 = 1000;

        Thread[] threads2 = new Thread[numThreads2];

        for (int i = 0; i < numThreads2; i++) {
            threads2[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread2; j++) {
                    counterV2.increment();
                }
            });
            threads2[i].start();
        }

        for (Thread t : threads2) {
            t.join();
        }

        System.out.println("Final counter value: " + counterV2.get());
        // Expect 1000  ---->>> and everytime it is 1000


        //v3 by atomic integer
        CounterV2 counterV3 = new CounterV2();
        int numThreads3 = 10;
        int incrementsPerThread3 = 1000;

        Thread[] threads3 = new Thread[numThreads3];

        for (int i = 0; i < numThreads3; i++) {
            threads3[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread3; j++) {
                    counterV3.increment();
                }
            });
            threads3[i].start();
        }

        for (Thread t : threads3) {
            t.join();
        }

        System.out.println("Final counter value: " + counterV3.get());
        // Expect 1000  ---->>> and everytime it is 1000

    }
}
