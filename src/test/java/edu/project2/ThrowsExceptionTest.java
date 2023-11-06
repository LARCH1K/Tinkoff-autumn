package edu.project2;

import edu.project2.components.Coordinate;
import edu.project2.components.Maze;
import edu.project2.generators.AldousBroderGenerator;
import edu.project2.generators.DFSGenerator;
import edu.project2.generators.Generator;
import edu.project2.renderers.ConsoleRenderer;
import edu.project2.renderers.Renderer;
import edu.project2.solvers.DFSSolver;
import edu.project2.solvers.Solver;
import edu.project2.solvers.WaveSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ThrowsExceptionTest {
    @Test
    void generatorDFSWithWrongInputTest() {
        Generator generator = new DFSGenerator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(-5, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(5, -4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(0, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(5, 0));
    }

    @Test
    void aldousBroderGeneratorWithWrongInputTest() {
        Generator generator = new AldousBroderGenerator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(-5, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(5, -4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(0, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(5, 0));
    }

    @Test
    void solverDFSWithWrongInputTest() {
        Solver solver = new DFSSolver();
        Generator generator = new DFSGenerator();
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(null, new Coordinate(1, 2), new Coordinate(4, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), null, new Coordinate(4, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(1, 2), null)
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(0, 2), new Coordinate(4, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(1, 2), new Coordinate(-5, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(1, 8), new Coordinate(4, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(1, 2), new Coordinate(13, 5))
        );
    }

    @Test
    void waveSolverWithWrongInputTest() {
        Solver solver = new WaveSolver();
        Generator generator = new AldousBroderGenerator();
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(null, new Coordinate(1, 2), new Coordinate(4, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), null, new Coordinate(4, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(1, 2), null)
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(0, 2), new Coordinate(4, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(1, 2), new Coordinate(-5, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(1, 8), new Coordinate(4, 5))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(generator.generate(5, 5), new Coordinate(1, 2), new Coordinate(13, 5))
        );
    }

    @Test
    void consoleRenderWithWrongInputTest() {
        Solver solver = new WaveSolver();
        Generator generator = new AldousBroderGenerator();
        Renderer renderer = new ConsoleRenderer();
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> renderer.render(null)
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> renderer.render(null, new ArrayList<>())
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> renderer.render(generator.generate(5, 5), null)
        );
    }
}
