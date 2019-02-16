/**
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] cArr = s.toCharArray();
        
        if(len==1) return 1;
        int[][] mat = new int[len][len];
        
        for(int i=0;i<len;i++)
            mat[i][i] = 1;
        
        for(int l =2 ; l<=len;l++)
        {
            for(int i=0;i<len-l+1;i++)
            {
                int j=i+l-1;
                if(l==2 && cArr[i]==cArr[j])
                    mat[i][j]=2;
                else if(cArr[i]==cArr[j])
                {
                     mat[i][j]= 2+mat[i+1][j-1];
                }
                else {
                    mat[i][j] = Math.max(mat[i+1][j], mat[i][j-1]);
                }
            }
        }
        return mat[0][len-1];
    }
}