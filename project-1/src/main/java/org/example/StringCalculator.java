package org.example;

public class StringCalculator {


    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] numberArray = numbers.split(",");
        int sum = 0;
        for (String number : numberArray) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}