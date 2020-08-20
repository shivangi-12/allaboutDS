package com.java.ds.stack.uses;

import java.util.Stack;

public class LargestAreaHistogram {
static int largestRectangularArea(int[] heights) {
	int max_area=0;
	Stack<Integer> s=new Stack<>();
	// To store the top element of the stack
	int tp=0;
	// To store area with top bar as the smallest bar
	int area_with_top=0;
	int i=0;
	while(i<heights.length) {
		// If the bar is higher than the bar  at the top of stack then push this bar onto the stack
		if(s.empty()||heights[s.peek()]<=heights[i]) {
			s.push(i);
		}
		else {
			tp=s.peek();
			s.pop();
			 // Calculate the area with heights[tp] stack as smallest bar 
            area_with_top = heights[tp] * (s.empty() ? i : i - s.peek() - 1);
            // Update max_area if neccessary
            if(max_area<area_with_top)
            	max_area=area_with_top;
            
		}
		 // Now pop the remaining bars from stack and calculate area with every 
        // popped bar as the smallest bar 
        while (s.empty() == false) 
        { 
            tp = s.peek(); 
            s.pop(); 
            area_with_top = heights[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        } 
	}
	
	return max_area;
	
	
}
public static void main(String args[]) {
	int heights[]= {2,1,4,5,6,2,1};
	System.out.print(largestRectangularArea(heights));
}
}
