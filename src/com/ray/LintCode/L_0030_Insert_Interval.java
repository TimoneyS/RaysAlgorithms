package com.ray.LintCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a non-overlapping interval list which is sorted by start point.
 *      
 *      Insert a new interval into it, make sure the list is still in order and `non-overlapping` (merge intervals if necessary).
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      (2, 5) into [(1,2), (5,9)]
 *      Output:
 *      [(1,9)]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:
 *      (3, 4) into [(1,2), (5,9)]
 *      Output:
 *      [(1,2), (3,4), (5,9)]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/insert-interval/description
 * @date   2019-07-10 23:01:16
 */
public class L_0030_Insert_Interval {

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
