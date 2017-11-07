package by.bsu.algorithms.algorithm.maze.printer;


import by.bsu.algorithms.algorithm.maze.Maze;
import by.bsu.algorithms.algorithm.maze.MazeCell;
import by.bsu.algorithms.algorithm.maze.generator.MazeGenerator;
import by.bsu.algorithms.algorithm.maze.generator.helper.GenerateHelper;
import by.bsu.algorithms.algorithm.maze.pathfinder.helper.FindPathHelper;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MazePrinter extends JPanel implements Runnable{

    private final int START_POSITION = 0;
    private final int SPEED_DRAWING = 1;

    private Maze maze;
    private MazeGenerator generator;

    private MazeCell current;
    private MazeCell finish;


    public MazePrinter(int width, int height){
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
        drawing.drawMaze(maze,g);


    }

    @Override
    public void run() {
        MazeCell[][] cells = maze.getCells();
        MazeCell current = cells[START_POSITION][START_POSITION];
        MazeCell next;

        Stack<MazeCell> stack = new Stack<>();

        current.setVisited();
        stack.push(current);
        while(!stack.isEmpty()){
            current = stack.peek();
            current.setCurrent(true);
            try {
                super.repaint();
                Thread.sleep(SPEED_DRAWING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            next = GenerateHelper.getNeighbor(current, maze);
            current.setCurrent(false);
            if (next!=null){
                next.setVisited();
                GenerateHelper.deleteWalls(current,next);
                stack.push(next);
            } else {
                stack.pop();
            }
        }

        Stack<MazeCell> path = new Stack<>();

        path.push(this.current);
        this.current.setFinderVisited();
        while(!path.isEmpty()){

            this.current = path.peek();
            this.current.setCurrent(true);
            try {
                super.repaint();
                Thread.sleep(SPEED_DRAWING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            next = FindPathHelper.getAvailableNeighbor(this.current, maze);

            this.current.setCurrent(false);
            if (next!=null){
                next.setFinderVisited();
                this.current.setPathCell(true);
                path.push(next);
                if (pathFound(next) ){
                    this.current = next;
                    break;
                }
            } else {
                path.pop().setPathCell(false);
            }
        }
        this.current.setCurrent(false);
        this.current.setPathCell(true);
        try {
            super.repaint();
            Thread.sleep(SPEED_DRAWING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean pathFound(MazeCell current){
        return current.getI() == maze.getCells().length-1 && current.getJ() == maze.getCells()[0].length-1;
    }


}
