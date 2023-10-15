package edu.hw2;

import edu.hw1.Task3;
import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @DisplayName("Test from task")
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(200.0);
    }

    @Test
    @DisplayName("Test constructor of Rectangle with negate values")
    void constructorOfRectangleWithNegateValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-2, -6));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(8, -7));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-16, 47));
    }

    @Test
    @DisplayName("Test constructor of Square with different values")
    void constructorOfSquareWithDifferentValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> new Square(2, 6));
        assertThrows(IllegalArgumentException.class, () -> new Square(8, 7));
        assertThrows(IllegalArgumentException.class, () -> new Square(16, 47));
    }
}
