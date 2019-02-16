/**
438. Find All Anagrams in a String

https://leetcode.com/problems/find-all-anagrams-in-a-string/
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        int pSum = 0;
        List<Integer>  list = new ArrayList<>();
        char[] pArry = p.toCharArray();
        Arrays.sort(pArry);
        p = new String(pArry);
        
        for(int i=0;i<lenS;i++)
        {
            int low = i;
            int high = i+lenP;
            
            if(high<=lenS){
                
                String str = s.substring(i, high);
                char[] sArry = str.toCharArray();
                Arrays.sort(sArry);
                str = new String(sArry);
                
                if(p.equals(str))
                    list.add(low);    
                }
            }
         return list;
        }
}