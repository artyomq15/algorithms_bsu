package by.bsu.algorithms.algorithm.tree.binarysearchtree;


public class TreePrinter {
    public void printTree(BinarySearchTree tree) {
        int depth = tree.getMaxDepth();
        String[] printingTree = new String[depth];
        printingTree = printTreeByLines(printingTree, tree.getRoot(), depth, 0);
        System.out.println("____________TREE_____________");
        for (String levelString : printingTree) {
            System.out.println(levelString);
        }
        System.out.println("_____________________________");
    }

    private String[] printTreeByLines(String[] array, Node node, int depth, int level) {
        for (int i = 0; i < Math.pow(2, depth - level); i++) {
            array[level] = array[level] + " ";
        }
        if (node != null) {
            array[level] = array[level] + node.getData();
        } else{
            array[level] = array[level] + " ";
        }
        for (int i = 0; i < Math.pow(2, depth - level); i++) {
            array[level] = array[level] + " ";
        }
        if (level + 1 < depth) {
            if (node==null){
                node = new Node();
            }
            array = printTreeByLines(array, node.getLeft(), depth, level + 1);
            array = printTreeByLines(array, node.getRight(), depth, level + 1);


        }
        return array;
    }

}
