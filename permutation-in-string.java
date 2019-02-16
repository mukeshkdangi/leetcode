/**
https://leetcode.com/problems/permutation-in-string/
567. Permutation in String

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/

class Solution {
    
    List<String> permStrList = new ArrayList<>();
    
    public boolean checkInclusion(String s1, String s2) {
        
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1>len2) return false;
        
        int freq1[] = new int[26]; 
        
        for(int i=0;i<len1;i++)
            freq1[s1.charAt(i)-'a']++;
        
        for(int i=0;i<=len2-len1; i++)
        {
            int freq2[] = new int[26];
            for(int j=0;j<len1;j++)
            {
                freq2[s2.charAt(i+j)-'a']++;
            }
            
            if(isMatches(freq1, freq2))
                return true;
        }
        return false;
    }
    private static boolean isMatches(int[] arr1, int[] arr2)
    {
        for(int i=0;i<26;i++)
        {
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
    
    private static void generateAllPermString(String s1, List<String >permStrList, String prefix)
    {
        int len = s1.length();
        if(len==0) permStrList.add(prefix);
        
        for(int i=0;i<len;i++)
        {
            generateAllPermString(s1.substring(0, i) + s1.substring(i+1, len), permStrList, prefix+s1.charAt(i));
        }
    }
}