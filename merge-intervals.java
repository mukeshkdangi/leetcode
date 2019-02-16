/**
https://leetcode.com/problems/merge-intervals/
56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    private class IntervalCom implements Comparator<Interval>{
            @Override
            public int compare(Interval it1, Interval it2)
            {
                return it1.start-it2.start;
            }
        } 
    public List<Interval> merge(List<Interval> intervals){
        
        
        
        Collections.sort(intervals, new IntervalCom());
        LinkedList<Interval> mergedInterval = new LinkedList<>();
        
        for(Interval inteval : intervals)
        {
            if(mergedInterval.isEmpty() || (mergedInterval.getLast().end < inteval.start))
            {
                mergedInterval.add(inteval);
            }else{
                mergedInterval.getLast().end  = Math.max(mergedInterval.getLast().end, inteval.end);
            }
        }
        
    return mergedInterval;
        
    }
}