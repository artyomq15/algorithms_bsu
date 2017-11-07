package by.bsu.algorithms.runner;

import by.bsu.algorithms.algorithm.maze.generator.MazeGenerator;
import by.bsu.algorithms.algorithm.maze.printer.MazePrinter;

public class MazeRunner {
    public static void main(String[] args) {

        /*MazeGenerator generator = new MazeGenerator(10,10);
        MazePrinter printer = new MazePrinter();
        generator.generateMaze();*/

        new MazePrinter(15,15);
    }
}
