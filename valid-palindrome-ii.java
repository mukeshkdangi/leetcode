/**
Valid Palindrome II
https://leetcode.com/problems/valid-palindrome-ii/
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
*/

class Solution {
    public boolean validPalindrome(String s) {
     
        int low =0, high = s.length();
       return isValidPlain(s, low, high-1);
    }
    
    private static boolean isValidPlain(String s, int low, int high)
    {
          while(low<high)
        {
            if(s.charAt(low)==s.charAt(high))
            {
               low++;
                high--;
            }else
            {
                return isPalin(s, low+1, high) || isPalin(s, low, high-1);
            }
        }
        
        return true;
    }
    
    private static boolean isPalin(String s , int low, int high)
    {
        while(low<high)
        {
            if(s.charAt(low)!=s.charAt(high)) return false;low++;high--;
            
        }
        return true;
    }
}