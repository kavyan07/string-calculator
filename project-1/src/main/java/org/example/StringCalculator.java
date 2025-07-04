package org.example;

public class StringCalculator {

        public int add(String numbers) {
            if (numbers == null || numbers.isEmpty()) {
                return 0;
            }

            return Integer.parseInt(numbers);
        }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}