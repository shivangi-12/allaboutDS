package com.java.ds.tree.bst;



public class SumOfAllLevels {
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
     // For counting level wise sum we have to do level order traversal for which we need to
    // calculate the height of the tree i.e. level is height + 1.
    static int getHeight(TreeNode node) {
    	if(node.left==null &&node.right==null)
    		return 0;
    	int left=0;
    	if(node.left!=null)
    		left=getHeight(node.left);
    	int right=0;
    	if(node.right!=null)
    		right=getHeight(node.right);
    	return (Math.max(left, right)+1);
    }
    static void calculateSumLevel(TreeNode node,int level,int sum[]) {
    	if(node==null)
    		return;
    	sum[level]+=node.data;
    	calculateSumLevel(node.left,level+1,sum);
    	calculateSumLevel(node.right,level+1,sum);
    	
    }
    static void printArr(int arr[], int n)  
    {  
        for (int i = 0; i < n; i++)  
            System.out.print(arr[i]+ " " );  
    }  
    public static void main(String args[]) {
    	SumOfAllLevels tree=new SumOfAllLevels();
    	tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(20);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(8);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(25);
        int levels = getHeight(tree.root) + 1;  
        
        // To store the sum at every level  
        int sum[]=new int[levels];  
        calculateSumLevel(tree.root, 0, sum);  
      
        // Print the required sums  
        printArr(sum, levels);
    	
    }
    
}
