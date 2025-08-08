package org.example.medium;

import java.util.function.IntConsumer;

public class FizzBuzzPrinter {
    private int number;
    private int counter = 1;

    FizzBuzzPrinter(int number) {
        this.number = number;
    }

    public synchronized void printFizz(Runnable fizz) throws InterruptedException {
        while (counter <= number) {
            while (counter <= number && !(counter % 3 == 0 && counter % 5 != 0)) {
                wait();
            }
            if (counter <= number) {
                fizz.run();
                counter++;
                notifyAll();
            }
        }
    }

    public synchronized void printBuzz(Runnable buzz) throws InterruptedException {
        while (counter <= number) {
            while (counter <= number && !(counter % 3 != 0 && counter % 5 == 0)) {
                wait();
            }
            if (counter <= number) {
                buzz.run();
                counter++;
                notifyAll();
            }
        }
    }

    public synchronized void printFizzBuzz(Runnable buzz) throws InterruptedException {
        while (counter <= number) {
            while (counter <= number && !(counter % 3 == 0 && counter % 5 == 0)) {
                wait();
            }
            if (counter <= number) {
                buzz.run();
                counter++;
                notifyAll();
            }
        }
    }

    public synchronized void printNumber(IntConsumer num) throws InterruptedException {
        while (counter <= number) {
            while (counter <= number && (counter % 3 == 0 || counter % 5 == 0)) {
                wait();
            }
            if (counter <= number) {
                num.accept(counter);
                counter++;
                notifyAll();
            }
        }
    }

    public void printSimple(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
