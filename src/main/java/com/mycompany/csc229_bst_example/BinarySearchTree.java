package com.mycompany.csc229_bst_example;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;
    static final int COUNT = 10;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {
//this function insterts a node into the binary tree and puts the value where it belongs on the tree
        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
// this function allows us to print the binary tree in numerical order
        if (root == null)//checks to see if the node has a value
            return;// if it has no value end traversal
        doInOrder(root.getLeft());//stores data in root object after getting left value
        System.out.println(root.getData());//prints out root data using the getData function
        doInOrder(root.getRight());//root object now used getRight function to get the next value
    }
        public void preOrderTraversal(BstNode root) {//this function visits each node in the tree structure once
            if (root == null)
            return;
        System.out.print(root.getData() + " ");//uses getDat a function to start the order
        preOrderTraversal(root.getLeft());//reccursion to keep getting the left values until we hit a null value
        preOrderTraversal(root.getRight());//once there is a null  for left we get the right values
    }

    public Integer findHeight(BstNode root) {
        // this function finds how long the binary tree is
        // ToDo 3: Find the height of a tree
        if (root == null)//checks to see if the value in the traversal is null
            return -1;
        else
        {
            int lDepth = findHeight(root.getLeft());//checks the depth of the left values untill null with recursion
            int rDepth = findHeight(root.getRight());// checks the depth of the right values with recursion untill null
            
            if (lDepth > rDepth)//if statment used to determine which depth is larger and return the bigger value
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }

    

    public int getDepth(BstNode root, int x) {
        //this funtion checks to see how deep the binary tree goes beyond the root level
        //ToDo 4: complete getDepth of a node 
    if (root == null)//if the value is null then the function ends, used later with recusrion to traverse tree
        return -1;
    int dist = -1;//stores a value and starts -1 becuause we are starting from the root
    if ((root.getData() == x)||//checks for value of the node we are looking for
     
        (dist = getDepth(root.getLeft(), x)) >= 0 ||//uses recrusion to get the left sides depth
         
        (dist = getDepth(root.getRight(), x)) >= 0)//uses recursion to get the right sides depth
 
        // Return depth of the node
        return dist + 1;
         
    return dist;
        
    }
    
    static void print2DUtil(BstNode root, int space)
{
    // this function allows us to print the binary tree and give a visual representation of how it will be traversed
    // this function prints the far most right value first and then the one left of it
    //
    if (root == null)
        return;
 
    // Increase spacing between levels
    space += COUNT;
 
    // starts with the right side
    print2DUtil(root.getRight(), space);
 
    // Print current node after space
    // count
    System.out.print("\n");
    for (int i = COUNT; i < space; i++)
        System.out.print(" ");
    System.out.print(root.getData() + "\n");
 
    // moves onto the left side
    print2DUtil(root.getLeft(), space);
}
  
    
    
    
    
    
    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        //print("", root, false);
        // ToDo 5: complete the print of the BST
        
        //
        String tree = "";
        int test = 0;
        //preOrderTraversal(this.root);
        //printTree(this.root,tree);
        print2DUtil(this.root,test);
        
        
    }

   
   
   

}
