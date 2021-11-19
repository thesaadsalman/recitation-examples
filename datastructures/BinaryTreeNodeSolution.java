package datastructures;

import java.util.ArrayList;

public class BinaryTreeNodeSolution {
    public class BinaryTreeNode {

        public int data;
        public BinaryTreeNode left, right;
        
        public BinaryTreeNode (int d) {
            this.data = d;
        }
        
        public void invertTree(BinaryTreeNode root) {
            if(root.right != null) { 
                invertTree(root.right); 
            }
            if(root.left != null) { 
                invertTree(root.left); 
            }
            BinaryTreeNode toSwap = root.left;
            root.left = root.right;
            root.right = toSwap;
        }

        public boolean isBinarySearchTree(BinaryTreeNode root) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            makeList(root, arr);
            for(int i=1; i<arr.size(); i++){
                if(arr.get(i) <= arr.get(i-1)){
                    return false;               
                }
            }
            return true;
        }
        private void makeList(BinaryTreeNode root, ArrayList<Integer> arr){
            if(root == null){
                return;
            }
            makeList(root.left, arr);
            arr.add(root.data);
            makeList(root.right, arr);
            
        }

        public int sumEven(BinaryTreeNode root) {
            if(root == null){
                return 0;
            }

            int currentSum = 0;
            if(root.data % 2 == 0){
                currentSum += root.data;
            }

            currentSum += sumEven(root.left);
            currentSum += sumEven(root.right);

            return currentSum;

            // One-Line Solution
            // return (root.data % 2 == 0 ? root.data : 0) + sumEven(root.left) + sumEven(root.right);
        }
    }
    public static void main(String[] args){
        BinaryTreeNodeSolution solution = new BinaryTreeNodeSolution();
        BinaryTreeNode node = solution.new BinaryTreeNode(5);
        node.left = solution.new BinaryTreeNode(6);
        node.left.left = solution.new BinaryTreeNode(4);
        node.left.right = solution.new BinaryTreeNode(7);
        node.right = solution.new BinaryTreeNode(9);
        node.right.left = solution.new BinaryTreeNode(8);
        ArrayList<Integer> tree = new ArrayList<Integer>();
        node.makeList(node, tree);
        System.out.println(tree);
        System.out.println(node.sumEven(node));
        System.out.println(node.isBinarySearchTree(node));
        node.invertTree(node);
        tree.clear();
        node.makeList(node, tree);
        System.out.println(tree);
    }
}






