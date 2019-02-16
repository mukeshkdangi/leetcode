/**
https://leetcode.com/problems/maximum-subarray/
53. Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        int max_so_far = Integer.MIN_VALUE, max_here =0;
        
        for(int i=0;i<nums.length;i++)
        {
            max_here+=nums[i];
             if(max_so_far<=max_here)
                max_so_far = max_here;
            
             if(max_here<0) max_here=0;
        }
        
        return max_so_far;
        
    }
}