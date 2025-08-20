package org.example.medium;

public class PingPong {

    private int n;

    private boolean pingTurn = true;

    PingPong(int n) {
        this.n = n;
    }

    public synchronized void printPing() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (!pingTurn) {
                wait();
            }
            System.out.println("ping");
            pingTurn = false;
            notifyAll();
        }
    }

    public synchronized void printPong() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (pingTurn) {
                wait();
            }
            System.out.println("pong");
            pingTurn = true;
            notifyAll();
        }
    }



}
