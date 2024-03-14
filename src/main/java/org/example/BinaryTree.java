package org.example;



public class BinaryTree {
    private Node root;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isRoot(Node parent) {
        if (parent == null) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(Node node){
        if(node == null){
            return true;
        }
        return false;
    }

    public boolean isLeaf(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }
        return false;
    }

    public int getDegreeRoot(Node root) {
        int degree = 0;
        if (root == null) {
            return 0;
        }
        if (root.getLeft() != null) {
            degree++;
        }
        if (root.getRight() != null) {
            degree++;
        }
        return degree;
    }

    public int getHeightRoot(Node root) {
        if (isEmpty(root)) {
            return -1;
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                return 0;
            } else {
                if (root.getRight() != null && root.getLeft() != null) {
                    return (getHeightRoot(root.getRight()) + 1);
                }
                return (getHeightRoot(root.getLeft()) + 1);

            }
        }
    }
    int getDepth(Node root)
    {
        if (root == null)
            return 0;
        int leftDepth = getDepth(root.getLeft());
        int rightDepth = getDepth(root.getRight());

        if (leftDepth > rightDepth)
            return (leftDepth + 1);
        else
            return (rightDepth + 1);
    }
    private Node addRecursive(Node current, String value) {
        if (current == null) {
            return new Node(value);
        }
        if (current.getValue().compareTo(value) > 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (current.getValue().compareTo(value) < 0) {
            current.setRight(addRecursive(current.getRight(), value));
        } else {
            return current;
        }

        return current;
    }
    public void add(String value) {
        root = addRecursive(root, value);
    }

    public void preOrderTraversal(Node node){
        if(!isEmpty(node)){
            System.out.println(node.getValue());
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }
    public void postOrderTraversal(Node node){
        if(!isEmpty(node)) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.println(node.getValue());
        }
    }
    public void inOrderTraversal(Node node){
        if(!isEmpty(node)) {
            inOrderTraversal(node.getLeft());
            System.out.println(node.getValue());
            inOrderTraversal(node.getRight());
        }
    }
}

