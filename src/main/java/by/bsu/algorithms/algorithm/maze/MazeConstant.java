package by.bsu.algorithms.algorithm.maze;


import java.awt.*;

public final class MazeConstant {
    private MazeConstant(){}

    public final static int SPEED_DRAWING_MILLIS = 50;

    public final static int CELL_SIZE = 20;

    public final static int MARGIN = 10;

    public final static Color VISITED_CELL_COLOR = Color.PINK;
    public final static Color NOT_VISITED_CELL_COLOR = Color.WHITE;
    public final static Color FINDER_VISITED_CELL_COLOR = Color.YELLOW;
    public final static Color PATH_CELL_COLOR = Color.RED;
    public final static Color CURRENT_CELL_COLOR = Color.GREEN;

    public final static int WALL_WIDTH = 4;
    public final static Color WALL_COLOR = Color.BLACK;
}
