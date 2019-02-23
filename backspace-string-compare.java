/**
https://leetcode.com/problems/backspace-string-compare/
844. Backspace String Compare
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        
        char[] sChar = S.toCharArray();
        char[] tChar = T.toCharArray();
        
        for(int i=0;i<sChar.length;i++)
        {
            if(sChar[i]=='#' && !sStack.isEmpty())
            {
               
               sStack.pop();
            }else if(sChar[i]!='#')
            sStack.push(sChar[i]);
        }
        
            for(int i=0;i<tChar.length;i++)
        {
            if(tChar[i]=='#' && !tStack.isEmpty())
            {
             tStack.pop();
            }else if(tChar[i]!='#')
                tStack.push(tChar[i]);
        }
        
        while(!sStack.isEmpty() && !tStack.isEmpty())
        {
           if( sStack.pop() != tStack.pop()) return false;
        }
        
        return sStack.isEmpty() && tStack.isEmpty();
        
    }
}