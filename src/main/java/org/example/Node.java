package org.example;

import java.util.Objects;

public class Node {
    private String value;
    private Node parent;
    private Node right;
    private Node left;

    public Node(String value){
        this.value = value;
        right = null;
        left = null;
        parent = null;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setValue(String value){
        this.value = value;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    public Node getRight(){
        return right;
    }

    public Node getLeft(){
        return left;
    }

    public String getValue(){
        return value;
    }

    public Node parent(){
        return parent;
    }

    public boolean isRoot(){
        if(parent == null){
            return true;
        }
        return false;
    }

    public boolean isLeaf(){
        if(right == null && left == null){
            return true;
        }
        return false;
    }

    public int getNodeHeight(Node node, int height){
        if( node.parent == null){
            return height;
        }
        return getNodeHeight(node.parent, height+1);
    }

    public int getDegreeNode(Node node) {
        int degree = 0;
        if (node == null) {
            return 0;
        }
        if (node.getLeft() != null) {
            degree++;
        }
        if (node.getRight() != null) {
            degree++;
        }
        return degree;
    }
    public int getLevel(Node node, String value, int level) {
        if (node == null) {
            return 0;
        }
        if (Objects.equals(node.value, value)) {
            return level;
        }
        int downlevel = getLevel(node.left, value, level + 1);
        if (downlevel != 0) {
            return downlevel;
        }
        downlevel = getLevel(node.right, value, level + 1);
        return downlevel;
    }

}