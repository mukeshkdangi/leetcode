/**

https://leetcode.com/problems/largest-rectangle-in-histogram/
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        
        int top=0, maxArea=0, area =0,i;
        
        for(i=0;i<heights.length;)
        {
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i])
            {
                stack.push(i++);
            }else{
                top = stack.pop();
                if(stack.isEmpty() )
                {
                    area = i*heights[top];
                }else{
                    area=  heights[top]*(i-stack.peek()-1);
                    
                }
                 if(maxArea < area)  maxArea=  area;
            }
           
        }
        
        while(!stack.isEmpty())
        {
            top = stack.pop();
                if(stack.isEmpty() )
                {
                    area = i*heights[top];
                }else{
                    area=  heights[top]*(i-stack.peek()-1);
                }
            if(maxArea < area)  maxArea =  area;
        }
            
        
        return maxArea;
        }
}