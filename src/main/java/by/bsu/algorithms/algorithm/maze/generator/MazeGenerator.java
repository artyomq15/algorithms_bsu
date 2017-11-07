package by.bsu.algorithms.algorithm.maze.generator;


import by.bsu.algorithms.algorithm.maze.Maze;
import by.bsu.algorithms.algorithm.maze.MazeCell;
import by.bsu.algorithms.algorithm.maze.generator.helper.GenerateHelper;

import java.util.Stack;

public class MazeGenerator {
    private final int DEFAULT_DIMENSION = 10;
    private final int START_POSITION = 0;

    private Maze maze;

    public MazeGenerator() {
        maze = new Maze(DEFAULT_DIMENSION, DEFAULT_DIMENSION);
    }

    public MazeGenerator(int width, int height) {
        maze = new Maze(width, height);
    }

    public MazeGenerator(int dimension) {
        this(dimension, dimension);
    }

    public Maze getMaze() {
        return maze;
    }

    public void generateMaze() {
        MazeCell[][] cells = maze.getCells();
        MazeCell current = cells[START_POSITION][START_POSITION];
        MazeCell next;

        Stack<MazeCell> stack = new Stack<>();

        current.setVisited();
        stack.push(current);
        while(!stack.isEmpty()){
            current = stack.peek();
            next = GenerateHelper.getNeighbor(current, maze);
            if (next!=null){
                next.setVisited();
                GenerateHelper.deleteWalls(current,next);
                stack.push(next);
            } else {
                stack.pop();
            }
        }
    }


}
