package org.example.medium;

import java.util.function.IntConsumer;

public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzzPrinter fb = new FizzBuzzPrinter(15);

        Runnable fizz = () -> System.out.println("fizz");
        Runnable buzz = () -> System.out.println("buzz");
        Runnable fizzbuzz = () -> System.out.println("fizzbuzz");
        IntConsumer num = (x) -> System.out.println(x);

        Thread t1 = new Thread(() -> {
            try {
                fb.printFizz(fizz);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fb.printBuzz(buzz);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                fb.printFizzBuzz(fizzbuzz);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                fb.printNumber(num);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

