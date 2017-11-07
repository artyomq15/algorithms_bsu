package by.bsu.algorithms.algorithm.maze;


public class MazeCell {
    private int i;
    private int j;
    private boolean visited;
    private boolean walls[] = {true, true, true, true};

    private boolean current;

    private boolean pathCell;
    private boolean finderVisited;


    public MazeCell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public void deleteWall(int index){
        walls[index] = false;
    }

    public boolean[] getWalls() {
        return walls;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean isFinderVisited() {
        return finderVisited;
    }

    public void setFinderVisited() {
        this.finderVisited = true;
    }

    public boolean isPathCell() {
        return pathCell;
    }

    public void setPathCell(boolean pathCell) {
        this.pathCell = pathCell;
    }
}
