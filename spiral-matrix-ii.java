/**
59. Spiral Matrix II
https://leetcode.com/problems/spiral-matrix-ii/
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

class Solution {
    public int[][] generateMatrix(int n) {
        
        int rStart =0, cStart = 0, rEnd = n, cEnd =n;
        int[][] mat = new int[n][n];
        int count =1;
      while(rStart < n && cStart < n ){  
            for(int i=cStart;i<=cEnd-1;i++)
            {
                mat[rStart][i] =count++;
            }
            rStart++;

            for(int i=rStart; i<= rEnd-1; i++)
            {
                mat[i][cEnd-1]= count++;
                
            }
          
            cEnd--;
            for(int i=cEnd-1; i>=cStart;i--)
            {
                mat[rEnd-1][i] = count++;
            }
            rEnd --;

            for(int i=rEnd-1; i>=rStart;i--)
            {
                mat[i][cStart] = count++;
            }
          cStart ++;
      }
        
        return mat;
        
        
    }
}