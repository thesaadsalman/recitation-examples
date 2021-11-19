package datastructures;

import java.util.ArrayList;

public class BinaryTreeNode {
    
    public int data;
    public BinaryTreeNode left, right;
    
    public BinaryTreeNode (int d) {
        this.data = d;
    }
    
    public void invertTree(BinaryTreeNode root) {
        
    }

    public boolean isBinarySearchTree(BinaryTreeNode root) {
        return false;
    }

    public int sumEven(BinaryTreeNode root) {
        return 0;
    }
    public static void main(String[] args){
        BinaryTreeNode node = new BinaryTreeNode(5);
        node.left = new BinaryTreeNode(6);
        node.left.left = new BinaryTreeNode(4);
        node.left.right = new BinaryTreeNode(7);
        node.right = new BinaryTreeNode(9);
        node.right.left = new BinaryTreeNode(8);

        ArrayList<Integer> tree = new ArrayList<Integer>();

        // node.makeList(node, tree);

        System.out.println(tree);

        System.out.println(node.sumEven(node));

        System.out.println(node.isBinarySearchTree(node));

        node.invertTree(node);

        tree.clear();

        // node.makeList(node, tree);

        System.out.println(tree);
    }
}




