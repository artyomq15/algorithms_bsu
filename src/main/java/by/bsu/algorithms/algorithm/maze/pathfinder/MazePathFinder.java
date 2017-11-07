package by.bsu.algorithms.algorithm.maze.pathfinder;


import by.bsu.algorithms.algorithm.maze.Maze;
import by.bsu.algorithms.algorithm.maze.MazeCell;
import by.bsu.algorithms.algorithm.maze.generator.helper.GenerateHelper;
import by.bsu.algorithms.algorithm.maze.pathfinder.helper.FindPathHelper;

import java.util.Stack;

public class MazePathFinder {
    private Maze maze;
    private MazeCell finish;
    private MazeCell current;

    private Stack<MazeCell> path;

    public MazePathFinder(Maze maze, MazeCell start, MazeCell finish){
        this.maze = maze;
        this.current = start;
        this.finish = finish;
        path = new Stack<>();
    }

    public void findPath(){
        MazeCell current = this.current;
        MazeCell next;

        current.setFinderVisited();
        path.push(current);

        do {
            current.setCurrent(true);
            next = FindPathHelper.getAvailableNeighbor(current, maze);
            current.setCurrent(false);

            if (next != null) {
                next.setFinderVisited();
                current.setPathCell(true);
                path.push(next);
            } else {
                path.pop().setPathCell(false);
            }
            current = path.peek();
        } while (!pathFound(current));
        current.setCurrent(false);
        current.setPathCell(true);
    }

    private boolean pathFound(MazeCell current){
        return current == finish;
    }

    public Stack<MazeCell> getPath() {
        return path;
    }
}
