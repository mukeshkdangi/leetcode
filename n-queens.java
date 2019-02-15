/**
https://leetcode.com/problems/n-queens/
NQueens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
*/

class Solution {
    static List<List<String>>  listOfList = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        listOfList = new LinkedList<>();
        int[][] mat = new int[n][n];
        if(n==0) return listOfList;
        solveNQProb(mat, n, 0);
        return listOfList;
    }
    private static void printmat(int[][] mat)
    {
        List<String> list = new ArrayList<String>();
        for(int i=0;i<mat.length;i++)
        {
            StringBuilder sbud = new StringBuilder();
            for(int j=0;j<mat.length;j++)
                sbud.append( mat[i][j] ==1 ? 'Q' :'.');
            list.add(sbud.toString()); 
        }
        
        listOfList.add(list);
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