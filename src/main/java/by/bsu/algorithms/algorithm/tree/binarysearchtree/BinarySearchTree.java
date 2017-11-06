package by.bsu.algorithms.algorithm.tree.binarysearchtree;


public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node getRoot(){
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else {
            node.setRight(insert(node.getRight(), data));
        }
        return node;
    }

    public Node search(int data) {
        return search(root, data);
    }

    private Node search(Node node, int data) {
        Node found = new Node();
        while ((node != null) && found!=null) {
            int nodeData = node.getData();
            if (data < nodeData) {
                node = node.getLeft();
            } else if (data > nodeData) {
                node = node.getRight();
            } else {
                found = node;
                break;
            }
            found = search(node, data);
        }
        return found;
    }

    public Node searchParent(int data){return searchParent(root, data, new Node());}

    private Node searchParent(Node node, int data, Node parent) {
        if (search(data).getData()==null){
            System.out.println("-");
            return parent;
        }
        Node found = new Node();
        while ((node != null) && found!=null) {
            int nodeData = node.getData();
            if (data < nodeData) {
                parent = node;
                node = node.getLeft();
            } else if (data > nodeData) {
                parent = node;
                node = node.getRight();
            } else {
                break;
            }
            found = searchParent(node, data, parent);
        }
        return parent;
    }

    public void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty");
        } else if (search(data) != null) {
            System.out.println("There is no such element");
        } else {
            root = delete(root, data);
            System.out.println(data + " deleted");
        }
    }

    private Node delete(Node node, int data) {
        Node helpNode1;
        Node helpNode2;
        if (node.getData() == data) {
            Node left = node.getLeft();
            Node right = node.getRight();
            if (left == null && right == null) {
                return null;
            } else if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                helpNode1 = right;
                helpNode2 = right;
                while (helpNode2.getLeft() != null) {
                    helpNode2 = helpNode2.getLeft();
                }
                helpNode2.setLeft(left);
                return helpNode1;
            }
        } else if (data < node.getData()) {
            node.setLeft(delete(node.getLeft(), data));
        } else {
            node.setRight(delete(node.getRight(), data));
        }
        return node;
    }

    public int getMaxDepth(){
        return getMaxDepth(root);
    }
    private int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = getMaxDepth(node.getLeft());
            int rightDepth = getMaxDepth(node.getRight());

            if (leftDepth > rightDepth )
                return leftDepth + 1;
            else
                return rightDepth + 1;
        }
    }

    public void rightRotation(int data) {
        Node parent = search(data);
        Node rotated = parent.getLeft();
        Node parentOfParent = searchParent(parent.getData());

        parent.setLeft(rotated.getRight());
        rotated.setRight(parent);

        if (parentOfParent.getData() == null) {
            root = rotated;
        } else if (parent.getData().equals(parentOfParent.getLeft().getData())) {
            parentOfParent.setLeft(rotated);
        } else {
            parentOfParent.setRight(rotated);
        }
    }

    public void leftRotation(int data) {
        Node parent = search(data);
        Node rotated = parent.getRight();
        Node parentOfParent = searchParent(parent.getData());

        parent.setRight(rotated.getLeft());
        rotated.setLeft(parent);

        if (parentOfParent.getData() == null) {
            root = rotated;
        } else if (parent.getData().equals(parentOfParent.getLeft().getData())) {
            parentOfParent.setLeft(rotated);
        } else {
            parentOfParent.setRight(rotated);
        }
    }
}
