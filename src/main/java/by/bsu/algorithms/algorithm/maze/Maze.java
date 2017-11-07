package by.bsu.algorithms.algorithm.maze;




public class Maze {
    private MazeCell[][] cells;

    public Maze(int width, int height) {
        cells = new MazeCell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new MazeCell(i, j);
            }
        }
    }

    public MazeCell[][] getCells() {
        return cells;
    }


}
