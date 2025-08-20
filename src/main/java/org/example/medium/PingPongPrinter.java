package org.example.medium;

public class PingPongPrinter {

    public static void main(String[] args) {
        int n = 3; // number of times to print ping/pong
        PingPong printer = new PingPong(n);

        Thread t1 = new Thread(() -> {
            try {
                printer.printPing();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                printer.printPong();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
    }
}
