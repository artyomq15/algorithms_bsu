package by.bsu.algorithms.algorithm.tree.binarysearchtree;

public class Node {
    private Node left;
    private Node right;
    private Integer data;

    public Node(){}

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
