package by.bsu.algorithms.runner;

import by.bsu.algorithms.algorithm.stable_marriage_problem.StableMarriageProblem;

import java.util.*;

public class StableMarriageRunner {
    public static void main(String[] args) {
        int[][] men = new int[][]{
                {0,2,3,1,5,4},
                {3,0,2,1,4,5},
                {5,4,0,2,3,1},
                {3,1,2,5,4,0},
                {2,4,0,3,1,5},
                {3,0,5,4,1,2}
        };

        int[][] women = new int[][]{
                {5,4,3,1,0,2},
                {2,5,0,1,3,4},
                {4,0,3,2,1,5},
                {3,5,0,2,1,4},
                {2,5,1,4,0,3},
                {0,1,3,5,4,2}
        };

        /*int[][] men = new int[][]{
                {2,3,0,1},
                {0,3,2,1},
                {2,0,1,3},
                {3,0,1,2}
        };

        int[][] women = new int[][]{
                {3,2,1,0},
                {3,0,2,1},
                {2,0,3,1},
                {1,2,0,3}
        };*/

        StableMarriageProblem smp = new StableMarriageProblem(men, women);
        Integer[] pairs = smp.findStablePairs();
        for (int i = 0; i<pairs.length;i++){
            System.out.println("Man: " + pairs[i] + " Woman: " + i);
        }

    }
}
