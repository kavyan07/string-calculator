import org.example.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void testEmptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testNullStringReturnsZero() {
        assertEquals(0, calculator.add(null));
    }

    @Test
    void testSingleNumberReturnsThatNumber() {
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }

    @Test
    void testTwoNumbersReturnSum() {
        assertEquals(6, calculator.add("1,5"));
        assertEquals(10, calculator.add("4,6"));
    }

    @Test
    void testMultipleNumbersReturnSum() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
        assertEquals(21, calculator.add("1,2,3,4,5,6"));
    }

    @Test
    void testNewLineDelimiterBetweenNumbers() {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("1\n2\n3,4"));
    }

    @Test
    void testCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(10, calculator.add("//|\n1|2|3|4"));
    }

    @Test
    void testNegativeNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1,2");
        });
        assertEquals("negative numbers not allowed -1", exception.getMessage());
    }

    @Test
    void testMultipleNegativeNumbersThrowsExceptionWithAllNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1,2,-3");
        });
        assertEquals("negative numbers not allowed -1,-3", exception.getMessage());
    }

    @Test
    void testCustomDelimiterWithNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("//;\n-1;2;-3");
        });
        assertEquals("negative numbers not allowed -1,-3", exception.getMessage());
    }

    @Test
    void testCustomDelimiterWithNewlinesAndPositiveNumbers() {
        assertEquals(10, calculator.add("//|\n1|2\n3|4"));
    }

    @Test
    void testCustomDelimiterWithNewlinesAndNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("//|\n-1|2\n-3|4");
        });
        assertEquals("negative numbers not allowed -1,-3", exception.getMessage());
    }

    @Test
    void testAllCombinationsWork() {
        assertEquals(0, calculator.add(""));
        assertEquals(5, calculator.add("5"));
        assertEquals(6, calculator.add("1,5"));
        assertEquals(15, calculator.add("1,2,3,4,5"));
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(10, calculator.add("//|\n1|2\n3|4"));

        assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,2"));
        assertThrows(IllegalArgumentException.class, () -> calculator.add("//;\n-1;2;-3"));
    }
    // Add to StringCalculatorTest.java

    @Test
    void testNumbersBiggerThan1000AreIgnored() {
        assertEquals(2, calculator.add("2,1001"));           // 1001 ignored
        assertEquals(1002, calculator.add("1000,1001,2"));   // 1001 ignored, 1000 included
        assertEquals(6, calculator.add("1,5,1001"));         // 1001 ignored
        assertEquals(0, calculator.add("1001"));             // Only 1001, ignored
        assertEquals(1000, calculator.add("1000"));          // 1000 is included
    }
    // Add to StringCalculatorTest.java

    @Test
    void testLongDelimiters() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
        assertEquals(10, calculator.add("//[abc]\n1abc2abc3abc4"));
        assertEquals(15, calculator.add("//[hello]\n1hello2hello3hello4hello5"));
    }

    @Test
    void testLongDelimitersWithNumbersOver1000() {
        assertEquals(6, calculator.add("//[***]\n1***5***1001"));      // 1001 ignored
        assertEquals(1006, calculator.add("//[abc]\n1000abc5abc1abc1001")); // 1001 ignored
    }

}