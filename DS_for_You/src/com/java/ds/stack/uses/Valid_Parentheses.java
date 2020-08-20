package com.java.ds.stack.uses;
import java.util.*; 
public class Valid_Parentheses {
	// Java program for checking 
	// balanced Parenthesis  
		static boolean areParanthesisBalanced(String str) 
		{ 
			// Using ArrayDeque is faster than using Stack class 
			Deque<Character> stack = new ArrayDeque<Character>(); 
			for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '[' || ch == '(' || ch == '{') {
				stack.push(ch);
			} else if ((ch == ']' || ch == '}' || ch == ')')
					&& (!stack.isEmpty())) {
				if (((char) stack.peek() == '(' && ch == ')')
						|| ((char) stack.peek() == '{' && ch == '}')
						|| ((char) stack.peek() == '[' && ch == ']')) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				if ((ch == ']' || ch == '}' || ch == ')')) {
					return false;
				}
			}
		
			}
			return (stack.isEmpty());
			} 

		/*driver program to test above functions*/
		public static void main(String[] args) 
		{ 
			String expr = "(]"; 
			if (areParanthesisBalanced(expr)) 
				System.out.println("Balanced "); 
			else
				System.out.println("Not Balanced "); 
		} 
	} 
