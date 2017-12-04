package by.bsu.algorithms.runner;


import by.bsu.algorithms.algorithm.tree.binarysearchtree.BinarySearchTree;
import by.bsu.algorithms.algorithm.tree.binarysearchtree.TreePrinter;

public class BSTRunner {
    public static void main(String[] args)  {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreePrinter treePrinter = new TreePrinter();
        binarySearchTree.insert(8);
        binarySearchTree.insert(10);
        binarySearchTree.insert(4);
        binarySearchTree.insert(9);
        binarySearchTree.insert(11);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(12);

        binarySearchTree.delete(10);



        treePrinter.printTree(binarySearchTree);

        binarySearchTree.rightRotation(4);

        treePrinter.printTree(binarySearchTree);

        binarySearchTree.leftRotation(2);

        treePrinter.printTree(binarySearchTree);

        binarySearchTree.rightRotation(8);

        treePrinter.printTree(binarySearchTree);

        //treePrinter.printTree(binarySearchTree);


    }


}
