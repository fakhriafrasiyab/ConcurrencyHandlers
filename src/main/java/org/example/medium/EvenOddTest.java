package org.example.medium;

public class EvenOddTest {

    public static void main(String[] args) {
        EvenOddPrinter printer  =  new EvenOddPrinter(9);

        Thread even= new Thread(printer::printEven);
        Thread odd= new Thread(printer::printOdd);

        even.start();
        odd.start();
    }
}
