package org.example;

import java.util.ArrayList;
import java.util.List;
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
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Invalid custom delimiter format");
            }
            String delimiterSection = numbers.substring(2, delimiterEndIndex);
            delimiter = Pattern.quote(delimiterSection) + "|,|\n";
            numbersToProcess = numbers.substring(delimiterEndIndex + 1);
        }
        String[] numberArray = numbersToProcess.split(delimiter);
        return calculateSum(numberArray);
    }
        // Update StringCalculator.java - modify calculateSum method

        private int calculateSum (String[]numberArray){
            List<Integer> negativeNumbers = new ArrayList<>();
            int sum = 0;

            for (String number : numberArray) {
                String trimmedNumber = number.trim();
                if (!trimmedNumber.isEmpty()) {
                    try {
                        int num = Integer.parseInt(trimmedNumber);

                        if (num < 0) {
                            negativeNumbers.add(num);
                        } else if (num <= 1000) {  //  Ignore numbers > 1000
                            sum += num;
                        }
                        // Numbers > 1000 are ignored (not added to sum)

                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid number format: " + trimmedNumber);
                    }
                }
            }

            // Check for negative numbers (existing code)
            if (!negativeNumbers.isEmpty()) {
                StringBuilder message = new StringBuilder("negative numbers not allowed ");
                for (int i = 0; i < negativeNumbers.size(); i++) {
                    message.append(negativeNumbers.get(i));
                    if (i < negativeNumbers.size() - 1) {
                        message.append(",");
                    }
                }
                throw new IllegalArgumentException(message.toString());
            }

            return sum;
        }




    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

}