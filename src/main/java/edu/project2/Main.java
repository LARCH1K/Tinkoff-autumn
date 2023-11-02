package edu.project2;

import edu.project2.generators.DFSGenerator;
import edu.project2.generators.Generator;
import edu.project2.renderers.ConsoleRenderer;
import edu.project2.renderers.Renderer;
import edu.project2.solvers.FirstSolver;
import edu.project2.solvers.Solver;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Generator firstGenerator = new DFSGenerator();
        Renderer consoleRenderer = new ConsoleRenderer();
        Solver solver = new FirstSolver();
        Maze maze = firstGenerator.generate(21, 21);
        System.out.println(consoleRenderer.render(maze));
        int x = new Scanner(System.in).nextInt()-1;
        int y = new Scanner(System.in).nextInt()-1;
        int x1 = new Scanner(System.in).nextInt()-1;
        int y1 = new Scanner(System.in).nextInt()-1;
        var f = solver.solve(maze, new Coordinate(x, y), new Coordinate(x1, y1));
        System.out.println(f);
        System.out.println(consoleRenderer.render(maze, f));
    }
}
