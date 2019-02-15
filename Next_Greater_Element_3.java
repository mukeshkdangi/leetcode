/**
https://leetcode.com/problems/next-greater-element-iii/
Next Greater Element III : 
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21
 

Example 2:

Input: 21
Output: -1
*/

class Solution {
    public int nextGreaterElement(int n) {

        char[] arr = String.valueOf(n).toCharArray();
        
        if(arr.length==1) return -1;
        boolean isExist = false;
        int i=0;
        for(i=arr.length-1;i>0;i--)
        {
            if(arr[i]>arr[i-1])
            { 
                isExist = true;
                i--;
                break;
            }
        }
        
        if(i==0 && !isExist) return -1;        
        
        int x= arr[i];
        int minIdex= i+1;
        int min = arr[minIdex];
        
        for(int j=minIdex+1;j<arr.length;j++)
        {
           
            if(arr[j]>x && arr[j]< arr[minIdex])
            {
                minIdex= j;
            }
        }
        char temp = arr[i];
        arr[i] = arr[minIdex];
        arr[minIdex] = temp;
        
        Arrays.sort(arr, i+1, arr.length);
        int val =-1;
        try{
           val = Integer.parseInt(new String(arr));
        }catch(Exception e){
            return -1;
        }
       return val;
    }
}