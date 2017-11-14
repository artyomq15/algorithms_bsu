package by.bsu.algorithms.runner;


import by.bsu.algorithms.algorithm.dijkstra.DijkstraAlgorithm;

public class DijkstraRunner {
    public static void main(String[] args) {
        /*int graph[][] = {
                { 0,  4,  3, -1, -1, -1, -1},
                {-1,  0, -1,  2,  5, -1, -1},
                {-1, -1,  0,  2, -1,  1, -1},
                {-1, -1, -1,  0,  3, -1, -1},
                {-1, -1, -1, -1,  0, -1,  5},
                {-1, -1, -1,  1,  3,  0, -1},
                {-1, -1, -1, -1, -1, -1,  0},

        };*/

        int graph[][] = {
                { 0,  8,  7,  2, -1, -1, -1},
                {-1,  0, -1, -1,  2, -1, -1},
                {-1, -1,  0, -1,  5, -1, -1},
                {-1, -1, -1,  0, -1,  1, -1},
                {-1, -1, -1, -1,  0, -1,  2},
                {-1, -1,  2, -1, -1,  0,  7},
                {-1, -1, -1, -1, -1, -1,  0},

        };

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);
        dijkstraAlgorithm.handle(0,6);
        System.out.println(dijkstraAlgorithm.constructPath());
    }
}
