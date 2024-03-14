package org.example;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.setRoot(new Node("A"));
        tree.getRoot().setLeft(new Node("B"));
        tree.getRoot().setRight(new Node("C"));
        tree.getRoot().getLeft().setLeft(new Node("D"));
        tree.getRoot().getRight().setLeft(new Node("E"));
        tree.getRoot().getRight().setRight(new Node("F"));

        System.out.println("\n");

        System.out.println("PréOrdem:");
        tree.preOrderTraversal(tree.getRoot());
        System.out.println("\n");

        System.out.println("PósOrdem:");
        tree.postOrderTraversal(tree.getRoot());
        System.out.println("\n");

        System.out.println("EmOrdem:");
        tree.inOrderTraversal(tree.getRoot());
        System.out.println("\n");

        System.out.println("Se o nó C é raiz: " + tree.searchNode(tree.getRoot(), "C").isRoot());
        System.out.println("Se o nó B  é folha: " + tree.searchNode(tree.getRoot(), "B").isLeaf());
        System.out.println("Se a árvore está vazia: " +  tree.isEmpty(tree.getRoot()));
        System.out.println("\n");

        System.out.println("A altura do nó A é: " + tree.searchNode(tree.getRoot(), "A").getNodeHeight(tree.getRoot(), 0));
        System.out.println("\n");

        System.out.println("O grau do nó C é: " + tree.searchNode(tree.getRoot(), "C").getNodeDegree(tree.getRoot()));
        System.out.println("\n");

        System.out.println("O nivel de E é: " + tree.searchNode(tree.getRoot(), "E").getLevel(tree.getRoot(), 0));
        System.out.println("\n");

        System.out.println("A altura da arvore é: " + tree.getHeight());
        System.out.println("\n");

        System.out.println("O grau da arvore é: " + tree.getDegreeRoot(tree.getRoot(), 0));
        System.out.println("A arvore é \n");
        tree.printLevelOrder(tree.getRoot());
    }
}