package org.example.medium;

public class EvenOddPrinter {

    private final int max;
    private int current = 0;


    public EvenOddPrinter(int max) {
        this.max = max;
    }

    public synchronized void printEven() {
        while (current <= max) {
            while (current % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }
            if (current <= max) {
                System.out.println("Thread A: " + current);
                current++;
                notifyAll();
            }
        }
    }

    public synchronized void printOdd() {
        while (current <= max) {
            while (current % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }
            if (current <= max) {
                System.out.println("Thread B: " + current);
                current++;
                notifyAll();
            }
        }
    }
}
