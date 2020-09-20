package com.java.ds.LinkedList.Single;

import java.util.Scanner;


public class LLDelete {
static Node head;
static Node tail ; 
static class Node {
	int data;
	Node next;
	Node(int d) {
		data=d;
		next=null;
	}
	 //Represent the head and tail of the singly linked list  
   // public Node head = null;  
     
}
static Scanner in=new Scanner(System.in);


public static void deleteFromEnd() {  
	  
    //Checks if the list is empty  
    if(head == null) {  
        System.out.println("List is empty");  
        return;  
    }  
    else {  
        //Checks whether the list contains only one element  
        if(head != tail ) {  
            Node current = head;  
            //Loop through the list till the second last element such that current.next is pointing to tail  
            while(current.next != tail) {  
                current = current.next;  
            }  
            //Second last element will become new tail of the list  
            tail = current;  
            tail.next = null;  
        }  
        //If the list contains only one element  
        //Then it will remove it and both head and tail will point to null  
        else {  
            head = tail = null;  
        }  
    }  
}
public void addNode(int data) {  
    //Create a new node  
    Node newNode = new Node(data);  

    //Checks if the list is empty  
    if(head == null) {  
        //If list is empty, both head and tail will point to new node  
        head = newNode;  
        tail = newNode;  
    }  
    else {  
        //newNode will be added after tail such that tail's next will point to newNode  
        tail.next = newNode;  
        //newNode will become new tail of the list  
        tail = newNode;  
    }  
}  
public static void printList(LLDelete list) 
{ 
    Node currNode = LLDelete.head; 

    System.out.print("LinkedList: "); 

    // Traverse through the LinkedList 
    while (currNode != null) { 
        // Print the data at current node 
        System.out.print(currNode.data + " "); 

        // Go to next node 
        currNode = currNode.next; 
    } 
} 
public static void main(String args[]) {
LLDelete list=new LLDelete();
//Adds data to the list  
list.addNode(1);  
list.addNode(2);  
list.addNode(3);  
list.addNode(4);  
LLDelete.deleteFromEnd();
printList(list);

}
}