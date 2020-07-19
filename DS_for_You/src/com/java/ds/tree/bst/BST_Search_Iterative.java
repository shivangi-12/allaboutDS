package com.java.ds.tree.bst;

import java.util.Scanner;

public class BST_Search_Iterative {
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
    public static boolean searchIteratively(TreeNode root,int value) {
    	while(root!=null) {
    		if(root.data==value)
    			return true;
    		if(value<root.data)
    			root=root.left;
    		if(value>root.data)
    			root=root.right;	
    	}
    	return false;
    	
    }
    public static void main(String args[]) {
    	BST_Search_Iterative tree = new BST_Search_Iterative();
    	int key;
    	@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
    	key=in.nextInt();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(20);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(8);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(25);
    	if(searchIteratively(tree.root, key)) 
    		System.out.println("YES");
    	else
    		System.out.println("NO");
    }
}
