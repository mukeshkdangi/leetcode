/**
977. Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
*/


class Solution {
    public int[] sortedSquares(int[] A) {
        
        int mid = 0;
        int len = A.length;
        if(len==0) return A;
        
        int midNxt=0;
        int[]  arr = new int[len];
        
        for(int i=0;i<len;i++)
        {
            if(A[i]>=0){
                mid = i;
                break;
            }
        }
        
        midNxt = mid;
        mid = mid-1;
       
        int count =0;
        while(mid>=0 && midNxt<len)
        {
            if(A[mid]==0){
                arr[count++] = 0;
                mid--;
            }
            if((A[mid] *-1) < A[midNxt])
            {
                arr[count++] = A[mid] * A[mid];
                mid--;
            } else {
                
                arr[count++] = A[midNxt] * A[midNxt];
                midNxt++;
            }  
        }
        
    while(midNxt<len)
        {
             arr[count++] = A[midNxt] * A[midNxt];
                midNxt++;
        }
        
        while(mid>=0)
        {        
                arr[count++] = A[mid] * A[mid];
                mid--;   
        }
      
        return arr;
        
    }
}