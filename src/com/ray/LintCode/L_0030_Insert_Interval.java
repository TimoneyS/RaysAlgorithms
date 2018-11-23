package com.ray.LintCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ray.io.Out;

/**
 * Given a non-overlapping interval list which is sorted by start point.
 * Insert a new interval into it,
 * make sure the list is still in order and non-overlapping (merge intervals if necessary).
 * 
 * 给定一系列的按照起点排序的彼此不重叠的区间。
 * 插入一个新的区间，保证插入后所有的区间依旧是不重叠的（可以合并区间）
 * 
 * <p>
 * Example
 * <p>
 * <li> Insert (2, 5) into [(1,2), (5,9)], we get [(1,9)].
 * <li> Insert (3, 4) into [(1,2), (5,9)], we get [(1,2), (3,4), (5,9)].
 * @author rays1
 *
 */
public class L_0030_Insert_Interval {
    
    static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return String.format("[%s, %s]", start, end);
        }
        
    }
    
    /**
     * 一个显然的改进是，先用二分搜索找到区间开始的结束的位置，然后插入区间
     * @author rays1
     *
     */
    static class Solution {
        
        /**
         * @param intervals: Sorted interval list.
         * @param newInterval: new interval.
         * @return: A new interval list.
         */
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

            List<Interval> newList = new ArrayList<>();
            
            boolean needAdd = true;
            for (Iterator<Interval> ite = intervals.iterator(); ite.hasNext();) {
                Interval interval = ite.next();
                
                if (interval.end < newInterval.start) {
                    newList.add(interval);
                } else if (interval.start > newInterval.end) {
                    if (needAdd) {
                        newList.add(newInterval);
                        needAdd = false;
                    }
                    newList.add(interval);
                } else {
                    newInterval.start = Math.min(interval.start, newInterval.start);
                    newInterval.end   = Math.max(interval.end, newInterval.end);
                }
                
            }
            if (needAdd)
                newList.add(newInterval);
            return newList;
        }
        
    }
    
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
         intervals.add(new Interval(7, 8));
         intervals.add(new Interval(10, 13));
         
       Out.p( new Solution().insert(intervals, new Interval(6, 6 )));
        
    }
    
}
