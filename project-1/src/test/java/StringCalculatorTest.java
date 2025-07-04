import org.example.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void testEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testSingleNumberReturnsThatNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }
    @Test
    void testTwoNumbersReturnSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,5"));
        assertEquals(10, calculator.add("4,6"));
    }
}