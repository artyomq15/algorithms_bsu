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
        MazeCell next;
        path.push(current);
        while(!pathFound()){
            current = path.peek();
            next = FindPathHelper.getAvailableNeighbor(current, maze);
            if (next!=null){
                next.setFinderVisited();
                current.setPathCell(true);
                path.push(next);
            } else {
                path.pop().setPathCell(false);
            }
        }
    }

    private boolean pathFound(){
        return current == finish;
    }

    public Stack<MazeCell> getPath() {
        return path;
    }
}
