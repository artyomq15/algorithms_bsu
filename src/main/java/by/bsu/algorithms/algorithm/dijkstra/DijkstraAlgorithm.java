package by.bsu.algorithms.algorithm.dijkstra;

import java.util.*;

public class DijkstraAlgorithm {
    private int[] labels;
    private int[] parents;
    private boolean[] visited;
    private int[][] graph;

    private int start;
    private int finish;



    public DijkstraAlgorithm() {

    }

    public DijkstraAlgorithm(int[][] graph) {
        this.graph = graph;
        init(graph.length);
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
        init(graph.length);
    }

    private void init(int size) {
        labels = new int[size];
        for (int i=0;i<labels.length;i++) {
            labels[i] = -1;
        }
        parents = new int[size];
        visited = new boolean[size];
    }

    public void handle(int start, int finish) {
        this.start = start;
        this.finish = finish;

        labels[start] = 0;
        parents[start] = -1;
        visited[start] = true;

        doStep();

        System.out.println("labels: " + Arrays.toString(labels));
        System.out.println("parents: " + Arrays.toString(parents));
        System.out.println("visited: " + Arrays.toString(visited));

    }

    private void doStep() {
        if (visited[finish]) {
            return;
        }


        int minLabel = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                for (int j = 0; j < visited.length; j++) {

                    if (!visited[j] && graph[i][j] > 0) {
                        int newLabel = labels[i] + graph[i][j];

                        if (labels[j] < 0) {
                            labels[j] = newLabel;
                            parents[j] = i;
                        } else if (newLabel < labels[j]) {
                            labels[j] = newLabel;
                            parents[j] = i;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (labels[i] < minLabel && labels[i]>0 && !visited[i]) {
                minIndex = i;
                minLabel = labels[i];
            }
        }
        visited[minIndex] = true;
        doStep();
    }

    public Deque<Integer> constructPath(){
        Deque<Integer> minPath = new LinkedList<>();
        minPath.addFirst(finish);
        for (int i = finish; i != start; ){
            i = parents[i];
            minPath.addFirst(i);
        }
        return minPath;
    }

}
