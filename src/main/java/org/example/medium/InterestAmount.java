package org.example.medium;

public class InterestAmount {

    public static void main(String[] args) {
        double amount  = 100;

        double rate = 0.20;

        double target =500;

        int years = 0;

        while(amount<target){
            amount += amount *rate;
            years++;
        }

        System.out.println(years);
    }
}
