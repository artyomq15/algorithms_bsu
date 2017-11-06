package by.bsu.algorithms.algorithm.breadthfirstsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BreadthFirstSearch {
    private int[][] graph;
    private Map<Integer, Integer> result;

    private Stack<Integer> stackOne;
    private Stack<Integer> stackTwo;

    public BreadthFirstSearch(int[][] graph) {
        this.graph = graph;
        result = new HashMap<>();
    }

    public void setGraph(int[][] graph){
        this.graph = graph;
        result.clear();
    }

    public Map<Integer,Integer> getResult(){
        return result;
    }

    public boolean isConnectedGraph(){
        return result.size()==graph.length;
    }

    public void tagVertices(){
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
        int label = 0;
        int vertex = 0;
        stackOne.add(vertex);
        doTagging(label);
    }

    private void doTagging(int label){
        int vertex;
        if (stackOne.isEmpty()){
            return;
        }
        while (!stackOne.isEmpty()){
            vertex = stackOne.pop();
            for (int i = 0; i<graph.length; i++){
                if (graph[vertex][i]==1 && !stackOne.contains(i) && !result.containsKey(i)){
                    stackTwo.push(i);
                }
            }
            result.put(vertex,label);
        }
        stackOne.addAll(stackTwo);
        stackTwo.clear();
        doTagging(++label);
    }

}
