package org.example;

public class StringCalculator {


    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] numberArray = numbers.split(",|\n");
        int sum = 0;
        for (String number : numberArray) {
            if (!number.trim().isEmpty()) {
                sum += Integer.parseInt(number.trim());
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}