import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Addition test")
    void testAddition() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    @DisplayName("Subtraction test")
    void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1");
    }

    @Test
    @DisplayName("Multiplication test")
    void testMultiplication() {
        assertEquals(5, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    @Test
    @DisplayName("Division test")
    void testDivision() {
        assertEquals(2.0, calculator.divide(6, 3), 0.001, "6 / 3 should equal 2.0");
    }

    @Test
    @DisplayName("Division by zero test")
    @Severity(SeverityLevel.CRITICAL)
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}

