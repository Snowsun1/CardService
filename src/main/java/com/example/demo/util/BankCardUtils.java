package com.example.demo.util;

public class BankCardUtils {
    public static int generateRandomBankCardNumber() {
        int max = 1000000000;
        int min = 100000000;
        //Random rand = new Random();
        int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
        return ii;
    }
}
