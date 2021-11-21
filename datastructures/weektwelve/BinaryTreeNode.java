package datastructures.weektwelve;

import java.util.ArrayList;


public class BinaryTreeNode {

    /**
     * Basic Binary Tree Node Class
     * @param data: Integer Value stored in Node
     * @param left, right: References to the left
     * and right node of this node. Default to null.
     */
    public int data;
    public BinaryTreeNode left, right;
    
    public BinaryTreeNode (int d) {
        this.data = d;
    }
    
    /**
     * Recursive method that takes in a BinaryTreeNode
     * and swaps the left and right children of the node,
     * and of all of the node's children.
     * 
     * @param root: The given node whose child nodes 
     * and descending tree we want to swap.
     */
    public void invertTree(BinaryTreeNode root) {
        // Base Case: If the node we're given is null, it doesn't have
        // any children to invert, so we can return and stop any further
        // recursive calls.
        if(root == null){
            return;
        }

        // Recursive Call: Now that we know we're in a node, we want
        // to call invertTree() on the left and right nodes of our
        // current node, so their subtrees are also inverted.
        // NOTE: This step can be done before or after the next step.
        invertTree(root.right);
        invertTree(root.left);

        // Visit Behavior: This is where we do our swapping! 
        // We want to start by storing our left node to a
        // temporary variable so we don't lose it on 
        // reassignment. Then, we assign our node's left
        // reference to the right node, and our right
        // reference to our temporary variable. And voila!
        // Our nodes are swapped!
        BinaryTreeNode toSwap = root.left;
        root.left = root.right;
        root.right = toSwap;
    }

    /**
     * Function that takes in the root node of a tree
     * and return the sum of all even valued nodes in the tree.
     * 
     * @param root: Given node we're searching for even
     * children and summing up
     * @return: Integer sum of all the even nodes
     */
    public int sumEven(BinaryTreeNode root) {
        // Base Case: If the node we're given is null,
        // it doesn't have any data for us to sum, nor
        // any children to sum, so we just return 0
        if(root == null){
            return 0;
        }

        // Integer variable to store our
        // accumulated sum at this node
        int currentSum = 0;

        // Visit Behavior: Now we've got to check if 
        // our node has data that's even. We use mod(2)
        // to find the remainder, and if it's 0, it's even!
        // Once we determine that, we add the data in our node
        // to our currentSum.
        if(root.data % 2 == 0){
            currentSum += root.data;
        }

        // Recursive Case: Now we want to do the same
        // operation on the children of this node - so,
        // we call sumEven() on the left and right nodes,
        // and add what we get back from them to currentSum,
        // so currentSum is now the sum of this node and of
        // its children and descendants. 
        currentSum += sumEven(root.left);
        currentSum += sumEven(root.right);

        // Finally, we return our current accumulated
        // sum of this node and it's children back up
        return currentSum;
    }

    /**
     * Same as the above, just written in one line.
     * 
     * Function that takes in the root node of a tree
     * and return the sum of all even valued nodes in the tree.
     * 
     * @param root: Given node we're searching for even
     * children and summing up
     * @return: Integer sum of all the even nodes
     */
    public int sumEvenOneLiner(BinaryTreeNode root){
        // Here we can demonstrate the importance of the return in Recursion.
        // The first section of this return is what's called a Ternary Statement:
        // It allows us to phrase an if statment in terms of a boolean question with
        // two outcomes, in the structure "Question ? do if true: do if false". In this
        // case, we ask if our root's data is even, and if so, return the data, if not return 0.
        // Then, we call our two recursive cases, and add them to the result of our ternary statment,
        // and then we finally return the whole thing. All in one line!
        return (root.data % 2 == 0 ? root.data : 0) + sumEvenOneLiner(root.left) + sumEvenOneLiner(root.right);
    }

    /**
     * Method that determines whether or not a given node 
     * is the root node of a valid Binary Search Tree.
     * 
     * Note: A Binary Search Tree is defined as a Tree where 
     * all of the nodes to the left of a given node are less
     * than that node, and all of the nodes to the right of
     * a given node are greater than that node.
     * 
     * @param root: the root node of the Binary Tree that we
     * want to validate for the characteristics of a BST.
     * @return: true or false, based on whether or not the 
     * tree is a Binary Search Tree
     */
    public boolean isBinarySearchTree(BinaryTreeNode root) {
        // We start by initializing an ArrayList to serve as
        // the storage for our tree data. 
        // REMEMBER: Objects in Java are passed by reference,
        // which means if we send this ArrayList to a fucntion, 
        // and hthe function adds to the ArrayList, those changes
        // will be reflected in this one we initialize here.
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // Now we call our Recursive function that takes in our
        // root node and our list, and will generate a list out 
        // of the tree. Notice that we aren't setting this equal
        // to anything, because the function doesn't return 
        // anything, it just makes changes to the ArrayList
        // that we passed in.
        makeList(root, arr);

        // In this for loop, we're checking to make sure that 
        // the ArrayList of our tree is sorted.  We loop through
        // every element in the list, and if any of them are out
        // of numerical order, we automatically end the function
        // and return false.
        for(int i=1; i<arr.size(); i++){
            if(arr.get(i) <= arr.get(i-1)){
                return false;               
            }
        }

        // If we've made it through the whole loop and didn't
        // return false, that means that our list is sorted,
        // so we can just return true.
        return true;
    }
    /**
     * Helper function that takes in a root of a tree and an ArrayList, and 
     * constructs an ArrayList representation of the data in the tree based
     * on in-order traversal. Effectively, the ordering of the list is the same
     * as if you were to read the tree from left to right.
     * 
     * @param root: The given node we are making a list out of
     * @param arr: The list to add node data to.
     */
    private void makeList(BinaryTreeNode root, ArrayList<Integer> arr){
        // Base Case: If the node we're given is null,
        // it doesn't have any data for us to add to
        // our list, so we can just return and end the fuction.
        if(root == null){
            return;
        }

        // Recurisve Case: To make this list, we're using
        // In-Order traversal. That means we apply recursion
        // to the left node, then perform our visit behavior
        // on our current node, then apply recursion to the
        // right node.
        makeList(root.left, arr);

        // Visit Behavior: All we do when we visit this node
        // is add its data to the list. 
        arr.add(root.data);

        // Recursive Case Part 2
        makeList(root.right, arr);
        
    }

    public static void main(String[] args){

        // The next 7 lines are the construction 
        // of a Binary Search Tree. The Tree this
        // makes is shown in the image ExampleTree.png
        // in the repository
        BinaryTreeNode node = new BinaryTreeNode(4);
        node.left = new BinaryTreeNode(2);
        node.left.left = new BinaryTreeNode(1);
        node.left.right = new BinaryTreeNode(3);
        node.right = new BinaryTreeNode(6);
        node.right.left = new BinaryTreeNode(5);
        node.right.right = new BinaryTreeNode(7);

        // This section creates an in-order list
        // of the example tree
        ArrayList<Integer> tree = new ArrayList<Integer>();
        node.makeList(node, tree);
        System.out.println("Example Tree listed with In-Order Traversal: " + tree);

        // Summing the even values of the example tree
        System.out.println("Sum of all even numbers of Example Tree: " + node.sumEven(node));

        //Validating that the example tree is a Binary Search Tree
        System.out.println("Is the Example Tree a Binary Search Tree: " + node.isBinarySearchTree(node));

        tree.clear();

        // A visual representation of what the Example Tree
        // looks like once inverted is down in the image
        // InvertedExampleTree.png in this repository
        node.invertTree(node);
        node.makeList(node, tree);
        System.out.println("Inverted Example Tree listed with In-Order Traversal: " + tree);
    }
}








