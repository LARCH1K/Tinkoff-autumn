package edu.hw2;


import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    @Test
    @DisplayName("Test from task")
    void rectangleArea() {
        Rectangle rect = new Rectangle(10,10);
        assertThat(rect.area()).isEqualTo(100);
        rect = new Rectangle(20,10);
        assertThat(rect.area()).isEqualTo(200);
        Square square = new Square(10);
        assertThat(square.area()).isEqualTo(100);
        square = new Square(20);
        assertThat(square.area()).isEqualTo(400);
    }

    @Test
    @DisplayName("Test constructor of Rectangle with negate values")
    void constructorOfRectangleWithNegateValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-2, -6));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(8, -7));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-16, 47));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 47));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(16, 0));
    }

    @Test
    @DisplayName("Test constructor of Square with negate values")
    void constructorOfSquareWithDifferentValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> new Square(-8));
        assertThrows(IllegalArgumentException.class, () -> new Square(-9));
        assertThrows(IllegalArgumentException.class, () -> new Square(0));
    }
}
