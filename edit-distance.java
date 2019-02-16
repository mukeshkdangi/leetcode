/**
72. Edit Distance
https://leetcode.com/problems/edit-distance/
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

class Solution {
    public int minDistance(String word1, String word2) {
        
        if(word1.length()<=0 && word2.length()>0){
            return word2.length();
        }
        if(word1.length()<=0 && word1.length()>0){
            return word1.length();
        }
        if(word1.length()<=0 && word2.length()<=0){
            return 0;
        }
        
        int[][] mat = new int[word1.length()+1][word2.length()+1];
        mat[0][0] = 0;
        for(int row=1;row<=word1.length();row++)
        {
            mat[row][0] = row;
        }
        
         for(int col=1;col<=word2.length();col++)
        {
            mat[0][col] = col;
        }
        
        
        for(int row=1;row<=word1.length();row++)
        {
            for(int col=1;col<=word2.length();col++)
                
        {
                if(word1.charAt(row-1)==word2.charAt(col-1))
                {
                    mat[row][col] = mat[row-1][col-1];
                }
                else {
                    mat[row][col] = Math.min(Math.min(mat[row][col-1], mat[row-1][col]), mat[row-1][col-1])+1;
                }
            }
            
        }
        
        return mat[word1.length()][word2.length()];
        
    }
}