package com.java.ds.LinkedList.Single;

import java.util.Scanner;

public class LLInsert {
Node head;
static class Node {
	int data;
	Node next;
	Node(int d) {
		data=d;
		next=null;
	}
}
static Scanner in=new Scanner(System.in);
public static LLInsert insertEnd(LLInsert list,int data) {
	Node new_node=new Node(data);
	new_node.next=null;
	if(list.head==null) {
		list.head=new_node;
		
	}
	else {
		Node last=list.head;
		while(last.next!=null) {
			last=last.next;
		}
		last.next=new_node;
		
	}
	
	return list;
	
}
public static LLInsert insertMid(LLInsert list,int data) {
	System.out.print("Enter the node value after which you want to insert data");
	int value=in.nextInt();
	Node new_node=new Node(data);
	Node temp=list.head;
	while(temp.data!=value) {
		temp=temp.next;
	}
	Node curpos=temp.next;
	temp.next=new_node;
	new_node.next=curpos;
	
	
	return list;
	
}
// Method to print the LinkedList. 
public static void printList(LLInsert list) 
{ 
    Node currNode = list.head; 

    System.out.print("LinkedList: "); 

    // Traverse through the LinkedList 
    while (currNode != null) { 
        // Print the data at current node 
        System.out.print(currNode.data + " "); 

        // Go to next node 
        currNode = currNode.next; 
    } 
} 
public static void main(String[] args) 
{ 
    /* Start with the empty list. */
    LLInsert list = new LLInsert(); 

    // 
    // ******INSERTION****** 
    // 

    // Insert the values 
    list = insertEnd(list, 1); 
    list = insertEnd(list, 2); 
    list = insertEnd(list, 3); 
    list = insertEnd(list, 4); 
    list = insertMid(list, 5); 
    list = insertEnd(list, 6); 
    list = insertMid(list, 7); 
    list = insertEnd(list, 8); 

    // Print the LinkedList 
    printList(list); 
} 
}

