package com.java.ds.tree.bst;

import java.util.Scanner;


public class BST_Insertion_Recursive {
	public TreeNode root;
    public static class TreeNode {
    	public TreeNode left;
    	public TreeNode right;
    	public int data;
    	public TreeNode(int data) {
    		this.data=data;
    		left=right=null;
    	}
    	
    }
public static TreeNode insertionRecursive(TreeNode root,int value) {
// If the tree contains no node , the node to insert will be the first node 
// and hence it will be the root. 
	if(root==null)
	return new TreeNode(value);
	if(value<root.data)
		root.left=insertionRecursive(root.left, value);
	else if(value>root.data)
		root.right=insertionRecursive(root.right, value);
	return root;


}
public static void printInorderTraversal(TreeNode root) {
	if (root != null) 
    { 
		printInorderTraversal(root.left); 
        System.out.print(root.data + " "); 
        printInorderTraversal(root.right); 
    } 
}
    	
    public static void main(String args[]) {
    	BST_Insertion_Recursive tree = new BST_Insertion_Recursive();
    	int[] key=new int[20];
    	@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
    	System.out.println("Enter the number of nodes :");
        int n=in.nextInt();
        for(int i=1;i<=n;i++) {
        	System.out.println("Enter the value to insert :");
        	key[i]=in.nextInt();
        	tree.root=insertionRecursive(tree.root,key[i]);
        	
        }
        printInorderTraversal(tree.root);
        
    }

}