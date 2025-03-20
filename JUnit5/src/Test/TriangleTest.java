package Test;
import JUnit5.Triangle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class TriangleTest {
    @Test
    void getType() {
        assertAll("triangleTypeTests",
                () -> assertEquals(3, Triangle.getType(2, 2, 2), ""),
                () -> assertEquals(0, Triangle.getType(1, 1, 2), "")
        );
    }
    @Test
    void getArea1() {
        assertAll("triangleAreaTests", () -> assertEquals(6, Triangle.getArea(3, 4, 5), ""));}
    @Test
    void getArea2() {
        assertAll("triangleAreaTests", () -> assertEquals(3, Triangle.getArea(2, 2, 2), ""));}
}