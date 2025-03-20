package Test;
import JUnit5.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    @Test
    void add() {assertAll("addTests", () -> assertEquals(2, Calculator.add(1, 1), ""));}
    @Test
    void sub() {assertAll("subTests", () -> assertEquals(8, Calculator.sub(10, 2), ""));}
    @Test
    void mul() {assertAll("mulTests", () -> assertEquals(6, Calculator.mul(2, 3), ""));}
    @Test
    void div() {assertAll("divTests", () -> assertEquals(2, Calculator.div(4, 2), ""));}
}