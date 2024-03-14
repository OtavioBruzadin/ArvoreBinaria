package org.example;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add("A");
        bt.add("B");
        bt.add("C");
        bt.add("D");
        bt.add("E");
        bt.add("F");

        bt.preOrderTraversal(bt.getRoot());
        System.out.println("\n");
        bt.postOrderTraversal(bt.getRoot());
        System.out.println("\n");
        bt.inOrderTraversal(bt.getRoot());
    }
}