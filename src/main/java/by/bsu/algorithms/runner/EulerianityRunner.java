package by.bsu.algorithms.runner;


import by.bsu.algorithms.algorithm.eulerianity.Eulerianity;

public class EulerianityRunner {
    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 1, 1},
                {0, 1, 0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 1},
                {0, 1, 1, 0, 1, 1, 0},

        };
        Eulerianity eulerianity = new Eulerianity(graph);
        eulerianity.findEulerianCycle();
        System.out.println(eulerianity.getCycle());
    }
}
