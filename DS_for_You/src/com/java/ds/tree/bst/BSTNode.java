package com.java.ds.tree.bst;
import java.util.*;
// Search and Insert operation in BST 
public class BSTNode {
private int  key;
private BSTNode left,right;
public BSTNode(int item) {
	key=item;
	left=right=null;
}
BSTNode(){
	root=null;
}
BSTNode root; 
	public static boolean search(BSTNode root,int key) {
		if(root==null )
			
			return false;
		if(root.key>key)
			return search(root.left,key);
		if(root.key==key)
			return true;
		
		return search(root.right,key);
		
	}
	 void insert(int key) { 
	       root = insertRec(root, key); 
	    } 
	      
	    /* A recursive function to insert a new key in BST */
	    BSTNode insertRec(BSTNode root, int key) { 
	  
	        /* If the tree is empty, return a new node */
	        if (root == null) { 
	            root = new BSTNode(key); 
	            return root; 
	        } 
	  
	        /* Otherwise, recur down the tree */
	        if (key < root.key) 
	            root.left = insertRec(root.left, key); 
	        else if (key > root.key) 
	            root.right = insertRec(root.right, key); 
	  
	        /* return the (unchanged) node pointer */
	        return root; 
	    }
	    static boolean ifnodeExists(BSTNode node,int key) {
	    	System.out.println("Searching for element :"+key);
			if(node==null)
	    	return false;
			if(node.key==key) {
				System.out.println("Element value comparison: "+ node.key +" : "+ key);
				return true;
			}
			boolean res1=ifnodeExists(node.left, key);
			if(res1) 
			{    System.out.print("Value of res1 "+res1);
                 return true;
				
			}
			boolean res2=ifnodeExists(node.right, key);
			
			return res2;
	    	
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		BSTNode bst=new BSTNode();
		int[] k=new int[10];
		System.out.println("Enter the number of nodes in the tree");
        int n=in.nextInt();
        for(int i=1;i<=n;i++) {
        	System.out.print("Enter a number to insert in the tree");
        	k[i]=in.nextInt();
        	bst.insert(k[i]);
        }
        for(int i=1;i<=n;i++) {
        	System.out.println(k[i]);
        }
        System.out.println("Enter the element to be searched");
        int search_key=in.nextInt();
        if (ifnodeExists(bst, search_key))  
            System.out.println("YES");  
        else
            System.out.println("NO"); 
	}
}

