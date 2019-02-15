/**
https://leetcode.com/problems/generate-parentheses/
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        char[] str = new char[2*n];
        generateParenthesis(str, 0, 0,0,n);
        return list;
    }
    
    private void generateParenthesis( char[] str , int pos, int open, int close, int len)
    {
        if(close == len) {
            list.add(String.valueOf(str));
            return;
        }
        
        if(close < open )
        {
            str[pos] =')';
            generateParenthesis(str, pos+1, open, close+1, len);
        } 
        if(open<len)
        {
             str[pos] ='(';
            generateParenthesis(str, pos+1, open+1, close, len);
        }
    }
}