package com.ray.LintCode.temp;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a collection of intervals, merge all overlapping intervals.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [(1,3)]
 *      Output: [(1,3)]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  [(1,3),(2,6),(8,10),(15,18)]
 *      Output: [(1,6),(8,10),(15,18)]
 *      ```
 *
 * 挑战：
 *      O(*n* log *n*) time and O(1) extra space.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/merge-intervals/description
 * @date   2019-07-11 18:31:18
 */
public class L_0156_Merge_Intervals {

    static class Solution {
        /**
         * @param intervals, a collection of intervals
         * @return: A new sorted interval list.
         */
        public List<Interval> merge(List<Interval> intervals) {
            
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval o1, Interval o2) {
                    return Integer.compare(o1.start, o2.start);
                }
            });
            
            List<Interval> rs = new LinkedList<Interval>();
            
            Interval old = null;
            for (Interval i : intervals) {
                if (old == null) { old = i; continue;}
                if (isIntersect(old, i)) {
                    old = merge(old, i);
                } else {
                    rs.add(old);
                    old = i;
                }
            }
            if (old != null) rs.add(old);
            
            
            
            return rs;
        }
        
        public boolean isIntersect(Interval i1, Interval i2) {
            return !(i1.start > i2.end || i2.start > i1.end);
        }
        
        public Interval merge(Interval i1, Interval i2) {
            return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
