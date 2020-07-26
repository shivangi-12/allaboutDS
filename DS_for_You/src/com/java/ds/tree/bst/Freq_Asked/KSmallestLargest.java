package com.java.ds.tree.bst.Freq_Asked;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class KSmallestLargest {
	public Node root;
    public static class Node {
    	public Node left;
    	public Node right;
    	public int data;
    	public Node(int data) {
    		this.data=data;
    		left=right=null;
    	}
    	
    }
    public static int Ksmallest(Node root,AtomicInteger i,int k) {
    	if(root==null)
    		return Integer.MIN_VALUE;
    	int left=Ksmallest(root.left, i, k);
    	if(left!=Integer.MIN_VALUE)
    		return left;
    	if(i.incrementAndGet()==k)
    		return root.data;
    	return Ksmallest(root.right,i,k);
    }
    public static int Ksmallest(Node root, int k)
	{
		// maintain index to count number of nodes processed so far
		AtomicInteger i = new AtomicInteger(0);

		// traverse the tree in in-order fashion and return k'th element
		return Ksmallest(root, i, k);
	}
    public static int Klargest(Node root,AtomicInteger i,int k) {
    	if(root==null)
    		return Integer.MAX_VALUE;
    	int right=Klargest(root.right, i, k);
    	if(right!=Integer.MAX_VALUE)
    		return right;
    	if(i.incrementAndGet()==k)
    		return root.data;
    	return Klargest(root.left,i,k);
    }
    public static int Klargest(Node root, int k)
	{
		// maintain index to count number of nodes processed so far
		AtomicInteger i = new AtomicInteger(0);

		// traverse the tree in in-order fashion and return k'th element
		return Klargest(root, i, k);
	}

public static void main(String args[]) {
	KSmallestLargest tree=new KSmallestLargest();
	Scanner in=new Scanner(System.in);
	tree.root = new Node(10);
    tree.root.left = new Node(5);
    tree.root.right = new Node(20);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(8);
    tree.root.right.left = new Node(15);
    tree.root.right.right = new Node(25);
    System.out.println("Enter the value of k for getting the smallest and largest number :");
	int k=in.nextInt();
	int smallest=Ksmallest(tree.root,k);
	System.out.println("The "+k+" smallest number is :"+smallest);
	int largest=Klargest(tree.root,k);
	System.out.println("The "+k+" largest number is :"+largest);
}
}
