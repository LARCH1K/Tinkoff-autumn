package edu.project2;

import edu.project2.components.Coordinate;
import edu.project2.components.Maze;
import edu.project2.generators.AldousBroderGenerator;
import edu.project2.generators.Generator;
import edu.project2.renderers.ConsoleRenderer;
import edu.project2.renderers.Renderer;
import edu.project2.solvers.Solver;
import edu.project2.solvers.WaveSolver;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static int HEIGHT = 11;
    private final static int WIDTH = 11;
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Scanner SCANNER = new Scanner(System.in);

    private Main() {
    }

    public static void main(String[] args) {
        Generator firstGenerator = new AldousBroderGenerator();
        Renderer consoleRenderer = new ConsoleRenderer();
        Solver solver = new WaveSolver();

        Maze maze = firstGenerator.generate(HEIGHT, WIDTH);

        LOGGER.info("\n" + consoleRenderer.render(maze));
        int x = SCANNER.nextInt();
        int y = SCANNER.nextInt();
        int x1 = SCANNER.nextInt();
        int y1 = SCANNER.nextInt();
        var f = solver.solve(maze, new Coordinate(x, y), new Coordinate(x1, y1));
        LOGGER.info("\n" + consoleRenderer.render(maze, f));
        LOGGER.info("\n" + consoleRenderer.render(maze));
    }
}
