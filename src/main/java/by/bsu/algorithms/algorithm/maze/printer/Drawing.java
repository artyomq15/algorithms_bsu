package by.bsu.algorithms.algorithm.maze.printer;


import by.bsu.algorithms.algorithm.maze.Maze;
import by.bsu.algorithms.algorithm.maze.MazeCell;

import java.awt.*;

import static by.bsu.algorithms.algorithm.maze.MazeConstant.*;

public class Drawing {

    public void drawMaze(Maze maze, Graphics2D g) {
        for (MazeCell[] cells : maze.getCells()) {
            for (MazeCell cell : cells) {
                drawCell(cell, g);
            }
        }
    }

    private void drawCell(MazeCell cell, Graphics2D g) {
        drawWalls(cell, g);
        int coordinateI = cell.getI() * CELL_SIZE + MARGIN;
        int coordinateJ = cell.getJ() * CELL_SIZE + MARGIN;

        if (cell.isVisited()) {
            g.setColor(VISITED_CELL_COLOR);
        } else {
            g.setColor(NOT_VISITED_CELL_COLOR);
        }

        if (cell.isFinderVisited()) {
            g.setColor(FINDER_VISITED_CELL_COLOR);
        }

        if (cell.isPathCell()) {
            g.setColor(PATH_CELL_COLOR);
        }

        if (cell.isCurrent()) {
            g.setColor(CURRENT_CELL_COLOR);
        }

        g.fillRect(coordinateI, coordinateJ, CELL_SIZE, CELL_SIZE);
    }

    private void drawWalls(MazeCell cell, Graphics2D g) {
        BasicStroke pen = new BasicStroke(WALL_WIDTH);
        g.setStroke(pen);
        g.setColor(WALL_COLOR);

        int coordinateI = cell.getI() * CELL_SIZE + MARGIN;
        int coordinateJ = cell.getJ() * CELL_SIZE + MARGIN;

        if (cell.getWalls()[0]) {
            g.drawLine(coordinateI, coordinateJ, coordinateI, coordinateJ + CELL_SIZE);
        }
        if (cell.getWalls()[1]) {
            g.drawLine(coordinateI, coordinateJ + CELL_SIZE, coordinateI + CELL_SIZE, coordinateJ + CELL_SIZE);
        }
        if (cell.getWalls()[2]) {
            g.drawLine(coordinateI + CELL_SIZE, coordinateJ, coordinateI + CELL_SIZE, coordinateJ + CELL_SIZE);
        }
        if (cell.getWalls()[3]) {
            g.drawLine(coordinateI, coordinateJ, coordinateI + CELL_SIZE, coordinateJ);
        }
    }
}
