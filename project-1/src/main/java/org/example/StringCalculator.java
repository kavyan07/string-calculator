package org.example;

import java.util.regex.Pattern;

public class StringCalculator {


    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numbersToProcess = numbers;

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            String delimiterSection = numbers.substring(2, delimiterEndIndex);
            delimiter = Pattern.quote(delimiterSection);
            numbersToProcess = numbers.substring(delimiterEndIndex + 1);
        }

        String[] numberArray = numbersToProcess.split(delimiter);
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