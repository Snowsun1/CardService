package com.example.demo.util;

public class BankCardUtils {
    private static final int max = 1000000000;
    private static final int min = 100000000;
    public static int generateRandomBankCardNumber() {
        return Math.abs(-min + (int) (Math.random() * ((max - (-min)) + 1)));
    }
}
