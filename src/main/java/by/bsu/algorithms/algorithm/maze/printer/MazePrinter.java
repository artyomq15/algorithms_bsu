package by.bsu.algorithms.algorithm.maze.printer;


import by.bsu.algorithms.algorithm.maze.Maze;
import by.bsu.algorithms.algorithm.maze.MazeCell;
import by.bsu.algorithms.algorithm.maze.MazeConstant;
import by.bsu.algorithms.algorithm.maze.generator.MazeGenerator;
import by.bsu.algorithms.algorithm.maze.generator.helper.GenerateHelper;
import by.bsu.algorithms.algorithm.maze.pathfinder.helper.FindPathHelper;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MazePrinter extends JPanel implements Runnable {

    private final int START_POSITION = 0;

    private Maze maze;
    private MazeGenerator generator;

    private MazeCell current;
    private MazeCell finish;


    public MazePrinter(int width, int height) {
        generator = new MazeGenerator(width, height);
        maze = generator.getMaze();

        current = maze.getCells()[0][0];

        drawingPanel();
        (new Thread(this)).start();
    }

    public void drawingPanel() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);
        frame.setTitle("Maze");
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(1, 1, 0, 0));
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        ((Graphics2D) graphics).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
        Drawing drawing = new Drawing();
        drawing.drawMaze(maze, g);


    }

    @Override
    public void run() {


        generateMaze();
        findPath();

    }

    private void generateMaze() {
        Stack<MazeCell> stack = new Stack<>();
        MazeCell current = maze.getCells()[START_POSITION][START_POSITION];
        MazeCell next;

        current.setVisited();
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.peek();
            current.setCurrent(true);
            repaintMaze();
            next = GenerateHelper.getNeighbor(current, maze);
            current.setCurrent(false);
            if (next != null) {
                next.setVisited();
                GenerateHelper.deleteWalls(current, next);
                stack.push(next);
            } else {
                stack.pop();
            }
        }

    }

    private void findPath() {
        Stack<MazeCell> path = new Stack<>();
        MazeCell current = this.current;
        MazeCell next;

        current.setFinderVisited();
        path.push(current);

        do {
            current.setCurrent(true);
            repaintMaze();
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
        repaintMaze();
    }

    private void repaintMaze() {
        try {
            super.repaint();
            Thread.sleep(MazeConstant.SPEED_DRAWING_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean pathFound(MazeCell current) {
        return current.getI() == maze.getCells().length - 1 && current.getJ() == maze.getCells()[0].length - 1;
    }


}
