/**
https://leetcode.com/problems/longest-palindromic-substring/
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1) return s;
        int len = s.length();
        boolean[][] mat = new boolean[len][len];
        
        String maxString  = "";
        int max =0;
        for(int l=0;l<len;l++)
        {
            for(int i=0;i<len-l;i++)
            {
                 mat[i][i] =true;
                int j = i+l;
                if(s.charAt(i)==s.charAt(j) && (l<=2 || mat[i+1][j-1]))
                {
                    mat[i][j] = true;
                    if(max<l+1){
                        max = l+1;
                        maxString = s.substring(i,j+1);
                    }
                }
            }
        }
        return maxString;
    }
}