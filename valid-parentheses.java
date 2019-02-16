/**
Valid Parentheses:

https://leetcode.com/problems/valid-parentheses/
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        
        for(int i=0;i<len;i++)
        {
            if(s.charAt(i)=='(')
                stack.push(')');
            else if(s.charAt(i)=='{')
              stack.push('}');
            else if(s.charAt(i)=='[')
              stack.push(']');
            else  if(!stack.isEmpty())
            {
                Character lastChar = stack.pop();
                if(s.charAt(i)!=lastChar) return false;
                
            } else {
                return false;
            }
        }
        
        return  stack.isEmpty() ? true:  false;
        
    }
}