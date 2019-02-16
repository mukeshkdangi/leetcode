/**
221. Maximal Square
https://leetcode.com/problems/maximal-square/
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/


class Solution {
    public int maximalSquare(char[][] mat) {
        
        int x = mat.length;
        if(x==0) return 0;
        int y =  mat[0].length;
        if(y==0 && x ==0) return 0;
        
        int[][] mat1 = new int[x][y];
        int max = 0;
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                if(i==0 || j==0) {
                    mat1[i][j] = mat[i][j]=='1' ?  1 :0;
                }
                else if(mat[i][j]=='1') {
                    mat1[i][j] = Math.min(Math.min(mat1[i-1][j-1], mat1[i-1][j]),mat1[i][j-1])+1;
                }
                if(max < mat1[i][j]) max = mat1[i][j];
            }
        }
        return max * max;
    }
}