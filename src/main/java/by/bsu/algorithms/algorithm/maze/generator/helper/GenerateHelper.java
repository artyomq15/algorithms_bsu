package by.bsu.algorithms.algorithm.maze.generator.helper;

import by.bsu.algorithms.algorithm.maze.Maze;
import by.bsu.algorithms.algorithm.maze.MazeCell;

import java.util.ArrayList;
import java.util.List;

public class GenerateHelper {

    public static MazeCell getNeighbor(MazeCell current, Maze maze) {
        MazeCell top = getNeighborCell(current.getI()-1, current.getJ(), maze);
        MazeCell right = getNeighborCell(current.getI(), current.getJ()+1, maze);
        MazeCell bottom = getNeighborCell(current.getI()+1, current.getJ(), maze);
        MazeCell left = getNeighborCell(current.getI(), current.getJ()-1, maze);

        List<MazeCell> neighbors = new ArrayList<>();

        if (top!=null && !top.isVisited()){
            neighbors.add(top);
        }
        if (right!=null && !right.isVisited()){
            neighbors.add(right);
        }
        if (bottom!=null && !bottom.isVisited()){
            neighbors.add(bottom);
        }
        if (left!=null && !left.isVisited()){
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

    public static void deleteWalls(MazeCell current, MazeCell next){
        if (current.getI() - next.getI() == 1){
            current.deleteWall(0);
            next.deleteWall(2);
        } else if (current.getI() - next.getI() == -1) {
            current.deleteWall(2);
            next.deleteWall(0);
        }

        if (current.getJ() - next.getJ() == 1){
            current.deleteWall(3);
            next.deleteWall(1);
        } else if (current.getJ() - next.getJ() == -1) {
            current.deleteWall(1);
            next.deleteWall(3);
        }
    }

}
