package by.bsu.algorithms.algorithm.maze.printer;


import by.bsu.algorithms.algorithm.maze.Maze;
import by.bsu.algorithms.algorithm.maze.MazeCell;

import java.awt.*;

public class Drawing {
    private int sizeCells = 10;

    public void drawMaze(Maze maze, Graphics2D g){
        for (MazeCell[] cells: maze.getCells()) {
            for (MazeCell cell: cells){
                drawCell(cell, g);
            }
        }
    }
    private void drawCell(MazeCell cell, Graphics2D g){
        drawWalls(cell,g);
        int coordinateI = cell.getI()*sizeCells+10;
        int coordinateJ = cell.getJ()*sizeCells+10;

        if (cell.isVisited()) {
            g.setColor(Color.pink);

        } else {
            g.setColor(Color.WHITE);
        }
        if (cell.isFinderVisited()){
            g.setColor(Color.yellow);
        }
        if (cell.isPathCell()){
            g.setColor(Color.RED);
        }
        if (cell.isCurrent()){
            g.setColor(Color.GREEN);
        }
        g.fillRect(coordinateI, coordinateJ, sizeCells, sizeCells);
    }

    private void drawWalls (MazeCell cell, Graphics2D g){
        BasicStroke pen = new BasicStroke(4);
        g.setStroke(pen);
        g.setColor(Color.BLACK);

        int coordinateI = cell.getI()*sizeCells+10;
        int coordinateJ = cell.getJ()*sizeCells+10;
        if (cell.getWalls()[0]){
            g.drawLine(coordinateI, coordinateJ, coordinateI, coordinateJ+sizeCells);
        }
        if (cell.getWalls()[1]){
            g.drawLine(coordinateI, coordinateJ+sizeCells, coordinateI+sizeCells, coordinateJ+sizeCells);
        }
        if (cell.getWalls()[2]){
            g.drawLine(coordinateI+sizeCells, coordinateJ, coordinateI+sizeCells, coordinateJ+sizeCells);
        }
        if (cell.getWalls()[3]){
            g.drawLine(coordinateI, coordinateJ, coordinateI+sizeCells, coordinateJ);
        }
    }
}
