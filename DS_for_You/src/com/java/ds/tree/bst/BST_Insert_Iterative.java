package com.java.ds.tree.bst;

import java.util.Scanner;


public class BST_Insert_Iterative {
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
public static TreeNode insertionIterative(TreeNode root,int value) {
	TreeNode current, parent;

    TreeNode tempNode = new TreeNode(value);

    if (root == null) {
        root = tempNode;
        return root;
    } else {
        current = root;
    }

    while (true) {
        parent = current;

        if (value < (int) current.data) {
            current = current.left;
            if (current == null) {
                parent.left = tempNode;
                return root;
            }

        } else if (value > (int) current.data) {
            current = current.right;

            if (current == null) {
                parent.right = tempNode;
                return root;
            }
        }

    }
}
public static void printInorderTraversal(TreeNode root) {
    if (root != null) {
        printInorderTraversal(root.left);
        System.out.print(root.data + " ");
        printInorderTraversal(root.right);
    }
}
    	
    public static void main(String args[]) {
    	BST_Insert_Iterative tree = new BST_Insert_Iterative();
    	int[] key=new int[20];
    	@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
    	System.out.println("Enter the number of nodes :");
        int n=in.nextInt();
        for(int i=1;i<=n;i++) {
        	System.out.println("Enter the value to insert :");
        	key[i]=in.nextInt();
        	tree.root=insertionIterative(tree.root,key[i]);
        	
        }
        printInorderTraversal(tree.root);
        
    }

}