package by.bsu.algorithms.runner;

import by.bsu.algorithms.algorithm.kruskal.Constant;
import by.bsu.algorithms.algorithm.kruskal.Kruskal;

import java.util.Arrays;

public class KruskalRunner {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,1,6},
                {0,2,1},
                {1,3,4},
                {1,4,2},
                {3,4,3},
                {2,3,2},
                {2,6,4},
                {2,5,3},
                {6,5,4},
                {3,5,2},
                {3,7,1},
                {5,7,2},
                {5,8,3},
                {8,7,1}

        };
        Kruskal kruskal = new Kruskal(graph, 9);
        int[][] result = kruskal.getMinSkeleton();
        for (int[] arr:result){
            if (arr[Constant.WEIGHT] != 0){
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(kruskal.getWeight());
    }
}
