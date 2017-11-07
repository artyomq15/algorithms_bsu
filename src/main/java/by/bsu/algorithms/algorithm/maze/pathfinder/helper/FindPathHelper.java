package by.bsu.algorithms.algorithm.maze.pathfinder.helper;


import by.bsu.algorithms.algorithm.maze.Maze;
import by.bsu.algorithms.algorithm.maze.MazeCell;

import java.util.ArrayList;
import java.util.List;

public class FindPathHelper {
    public static MazeCell getAvailableNeighbor(MazeCell current, Maze maze){
        MazeCell top = getNeighborCell(current.getI()-1, current.getJ(), maze);
        MazeCell right = getNeighborCell(current.getI(), current.getJ()+1, maze);
        MazeCell bottom = getNeighborCell(current.getI()+1, current.getJ(), maze);
        MazeCell left = getNeighborCell(current.getI(), current.getJ()-1, maze);

        List<MazeCell> neighbors = new ArrayList<>();

        if (top!=null && !top.isFinderVisited() && !current.getWalls()[0]){
            neighbors.add(top);
        }
        if (right!=null && !right.isFinderVisited() && !current.getWalls()[1]){
            neighbors.add(right);
        }
        if (bottom!=null && !bottom.isFinderVisited() && !current.getWalls()[2]){
            neighbors.add(bottom);
        }
        if (left!=null && !left.isFinderVisited() && !current.getWalls()[3]){
            neighbors.add(left);
        }

        if (neighbors.size()>0){
            return neighbors.get((int)(Math.random()*neighbors.size()));
        }
        return null;
    }

    private static MazeCell getNeighborCell(int i, int j, Maze maze) {
        if (i < 0 || j < 0 || i >= maze.getCells().length || j >= maze.getCells()[0].length) {
            return null;
        }
        return maze.getCells()[i][j];
    }
}
