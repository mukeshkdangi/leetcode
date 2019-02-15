/**
85. Maximal Rectangle
https://leetcode.com/problems/maximal-rectangle/
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/

class Solution {
    public int maximalRectangle(char[][] matx) {
        
        
  int rows = matx.length;
  if(rows==0) return 0;      
  int cols = matx[0].length;
        if(cols ==0 ) return 0;
  
  int mat[][] = new int[rows][cols];
  
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
          mat[i][j] = matx[i][j]=='1' ? 1 : 0;
      }
        }
        
  for(int i=1;i<rows;i++){
      for(int j=0;j<cols;j++){
        mat[i][j] = mat[i][j]>=1 ? mat[i-1][j] + mat[i][j] : mat[i][j] ;
         
      }
      
    }

    int res =0;
    for(int i=0;i<rows;i++){
      res = Math.max(res, getMaxArea(mat[i]));
    }       
        return res;
    }
    
    private static int getMaxArea(int[] heights)
  {
      

int top =0, area=0, maxArea =0, i=0, len= heights.length;
    Stack<Integer>  stack = new Stack<>();
    while(i<len)
    {
      if(stack.isEmpty() || heights[i]>=heights[stack.peek()]){
        stack.push(i++);
      }
      else 
      {
      top = stack.peek();
        stack.pop();
        
        if(stack.isEmpty()){
          area = heights[top] * i;
          
        }
        else if(!stack.isEmpty()) {
          area = heights[top] * (i-stack.peek()-1);
      
        }
        maxArea = maxArea < area ? area : maxArea;
      }
    }
     
        while(!stack.isEmpty())  
    {
      top = stack.peek();
        stack.pop();
        
        if(stack.isEmpty()){
          area = heights[top] * i;
       
        }
        else if(!stack.isEmpty()) {
          area = heights[top] * (i-stack.peek()-1);
        
        }
        maxArea = maxArea < area ? area : maxArea;
    }
    
    return maxArea;
  }
    
}
