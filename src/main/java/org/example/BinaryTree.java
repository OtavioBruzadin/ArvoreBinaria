package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty(Node node){
        if(node == null){
            return true;
        }
        return false;
    }

    public int getDegreeRoot(Node root, int degree ) {
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

    public int getHeightRoot(Node root)
    {
        if (root == null)
            return 0;
        else {
            int leftHeight = getHeightRoot(root.getLeft());
            int rightHeight = getHeightRoot(root.getRight());

            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }
    public int getHeight(){
        return getHeightRoot(this.root)-1;
    }
    public int getDepth(Node root)
    {
        if (root == null)
            return 0;
        else {
            int leftDepth = getDepth(root.getLeft());
            int rightDepth = getDepth(root.getRight());

            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }
    private Node addRecursive(Node root, String data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.compareTo(root.getValue()) < 0)
            root.setLeft( addRecursive(root.getLeft(), data));
        else if (data.compareTo(root.getValue()) > 0)
            root.setRight( addRecursive(root.getRight(), data));

        // Return the unchanged node pointer
        return root;
    }
    public void add(String value) {
        root = addRecursive(root, value);
    }

    public Node searchNode(Node current, String value){
        if (current == null)
            return null;
        if (current.getValue().equals(value)) {
            return current;
        }
        Node node = searchNode(current.getLeft(), value);
        if (node == null) {
            node = searchNode(current.getRight(), value);
        }
        return node;
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

    public void printLevelOrder(Node root)
    {

        if (root == null)
            return;

        Queue<Node> q = new LinkedList<Node>();

        q.add(root);

        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;
            while (nodeCount > 0) {
                Node node = q.peek();
                System.out.print(node.getValue() + " ");
                q.remove();
                if (node.getLeft() != null)
                    q.add(node.getLeft());
                if (node.getRight() != null)
                    q.add(node.getRight());
                nodeCount--;
            }
            System.out.println("\n");
        }
    }
}

