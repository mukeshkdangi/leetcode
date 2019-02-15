/**
52. N-Queens II
https://leetcode.com/problems/n-queens-ii/
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

class Solution {
    static int  total =0;
    public int totalNQueens(int n) {
    total =0;
        int[][] mat = new int[n][n];
        if(n==0) return n;
        solveNQProb(mat, n, 0);
        return total;
    }
    private static void printmat(int[][] mat)
    {
        total+=1;
    }
    
    private static void  solveNQProb(int[][] mat, int n, int col)
    {
        
        if(col==n){
            printmat(mat);
        }
        boolean res;
        for(int i=0;i<n;i++)
        {
            if(queenCanBePlaces(mat, i, col))
            {
                 mat[i][col] = 1;
                 solveNQProb(mat, n, col+1);
                 mat[i][col] = 0;
            }
        }
    }
    
    private static boolean queenCanBePlaces(int[][] mat, int row, int col)
    {
        for(int i=0;i<col;i++)
            if(mat[row][i]==1) return false;
        
        for(int i=row,j=col;i>=0 && j>=0;i--,j-- )
            if(mat[i][j]==1) return false;
        
        for(int i=row, j=col; i<mat.length && j>=0;i++, j--)
            if(mat[i][j]==1) return false;
        
        return true;
    }
}