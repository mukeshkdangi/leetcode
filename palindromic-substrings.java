/**
https://leetcode.com/problems/palindromic-substrings/
647. Palindromic Substrings
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

class Solution {
 public static int countSubstrings(String s) {
        int count = s.length();
        int len = s.length();
        
        for(int l=2;l<=len;l++)
        {
            for(int i=0;i<len-l+1;i++)
            {
                int j=i+l;
                if(isPlain(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
        
    }
    
    private static boolean isPlain(String s)
    {
        char[] cArr = s.toCharArray();
        int low=0, high=s.length()-1;
        while(low<=high)
        {
            if(cArr[low]!=cArr[high]) return false;
            low++;
            high--;
        }
        return true;
    }
}
       