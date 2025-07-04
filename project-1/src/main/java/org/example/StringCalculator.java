package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        return 0;
    }
    @Test
    void testSingleNumberReturnsThatNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}