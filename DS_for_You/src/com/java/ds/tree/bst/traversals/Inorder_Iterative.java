package com.java.ds.tree.bst.traversals;
import java.util.Stack;
public class Inorder_Iterative {
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
	    public static void inorderIterative(TreeNode root) {
	    	Stack<TreeNode> stack=new Stack();
	    	TreeNode curr=root;
	    	while(!stack.empty() || curr!=null) {
	    		if(curr!=null) {
	    			stack.push(curr);
	    			curr=curr.left;
	    		}
	    		else {
	    			curr=stack.pop();
	    			System.out.println(curr.data);
	    			curr=curr.right;
	    		}
	    	}
	    	
	    }
	    public static void main(String args[]) {
	    	Inorder_Iterative tree = new Inorder_Iterative();
	    	tree.root = new TreeNode(10);
	        tree.root.left = new TreeNode(5);
	        tree.root.right = new TreeNode(20);
	        tree.root.left.left = new TreeNode(4);
	        tree.root.left.right = new TreeNode(8);
	        tree.root.right.left = new TreeNode(15);
	        tree.root.right.right = new TreeNode(25);
	        inorderIterative(tree.root);
	    	
	    	
	    }
}
