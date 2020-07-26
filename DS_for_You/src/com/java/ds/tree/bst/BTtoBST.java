package com.java.ds.tree.bst;

import java.util.Arrays;
import java.util.Scanner;

import com.java.ds.tree.bst.BST_Insertion_Recursive.TreeNode;  

public class BTtoBST {  
      
    //Represent a node of binary tree  
    public static class Node{  
        int data;  
        Node left;  
        Node right;  
              
        public Node(int data){  
            //Assign data to the new node, set left and right children to null  
            this.data = data;  
            this.left = null;  
            this.right = null;  
            }  
        }  
      
    //Represent the root of binary tree  
    public Node root;  
    // Step 1: Converting the inorder traversal of BT into an array  
    int[] treeArray;  
    int index = 0;  
      
    public BTtoBST(){  
        root = null;  
    }  
      
    //convertBTBST() will convert a binary tree to binary search tree  
    public Node convertBTBST(Node node) {  
          
        //Variable treeSize will hold size of tree  
        int treeSize = calculateSize(node);  
        System.out.println("TreeSize is :"+treeSize);
        treeArray = new int[treeSize];  
          
        //Converts binary tree to array  
        convertBTtoArray(node);  
          
          //Sort treeArray  
        Arrays.sort(treeArray);  
        
        //Converts array to binary search tree  
        Node d = createBST(0, treeArray.length -1);  
        return d;  
    }  
      
    //calculateSize() will calculate size of tree  
    public int calculateSize(Node node)  
    {      
        int size = 0;  
        if (node == null)  
         return 0;  
        else {  
            size = calculateSize (node.left) + calculateSize (node.right) + 1; 
            System.out.println("The size comes to be "+size);
            return size;  
        }  
    }  
      
    //convertBTtoArray() will convert the given binary tree to its corresponding array representation  
    public void convertBTtoArray(Node node) {  
        //Check whether tree is empty  
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
        }  
        else {  
            if(node.left != null)  
                convertBTtoArray(node.left);  
            //Adds nodes of binary tree to treeArray  
            treeArray[index] = node.data;   
            index++;  
            if(node.right != null)  
                convertBTtoArray(node.right);    
            }        
        }  
      
    //createBST() will convert array to binary search tree  
    public Node createBST(int start, int end) {  
          
        //It will avoid overflow  
        if (start > end) {  
            return null;  
        }  
          
        //Variable will store middle element of array and make it root of binary search tree  
        int mid = (start + end) / 2;  
        Node node = new Node(treeArray[mid]);  
   
        //Construct left subtree  
        node.left = createBST(start, mid - 1);  
   
        //Construct right subtree  
        node.right = createBST(mid + 1, end);  
        System.out.println("The BST structure is :");
        
   
        return node;  
    }  
      
    //inorder() will perform inorder traversal on binary search tree  
    public void inorderTraversal(Node node) {  
          
        //Check whether tree is empty  
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
           }  
        else {  
              
            if(node.left!= null)  
                inorderTraversal(node.left);  
            System.out.print(node.data + " ");  
            if(node.right!= null)  
                inorderTraversal(node.right);  
                
          }        
      }  
    public static Node insertionRecursive(Node root,int value) {
    	// If the tree contains no node , the node to insert will be the first node 
    	// and hence it will be the root. 
    		if(root==null)
    		return new Node(value);
    		if(value<root.data)
    			root.left=insertionRecursive(root.left, value);
    		else if(value>root.data)
    			root.right=insertionRecursive(root.right, value);
    		return root;


    	}
    public static void main(String[] args) {  
          
    	BTtoBST bt = new BTtoBST();  
        //Add nodes to the binary tree  
        /*bt.root = new Node(1);  
        bt.root.left = new Node(2);  
        bt.root.right = new Node(3);  
        bt.root.left.left = new Node(4);  
        bt.root.left.right = new Node(5);  
        bt.root.right.left = new Node(6);  
        bt.root.right.right = new Node(7);  
          */
    	Scanner in=new Scanner(System.in);
    	int[] key=new int[20];
    	System.out.println("Enter the number of nodes:");
    	int n=in.nextInt();
    	for(int i=1;i<=n;i++) {
    		System.out.println("Enter the value to insert :");
        	key[i]=in.nextInt();
        	bt.root=insertionRecursive(bt.root,key[i]);
    	}
        //Display given binary tree  
        System.out.println("Inorder representation of binary tree: ");  
        bt.inorderTraversal(bt.root);  
          
        //Converts binary tree to corresponding binary search tree  
        Node bst = bt.convertBTBST(bt.root);  
          
        //Display corresponding binary search tree  
        System.out.println("\nInorder representation of resulting binary search tree: ");  
        bt.inorderTraversal(bst);  
      }  
}  