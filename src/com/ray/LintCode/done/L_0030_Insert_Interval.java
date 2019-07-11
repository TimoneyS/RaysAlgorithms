package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 描述：
 *      给出一个无重叠的按照区间起始端点排序的区间列表。
 *      在列表中插入一个新的区间，你要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
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
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/insert-interval/description
 * @date   2019-07-10 23:01:16
 */
public class L_0030_Insert_Interval {

    /**
     * 当前区间 a 和新区间 b 的关系
     *      1. b.end < a.start  新区间在旧区间的左侧，直接添加
     *      2. b.start <= a.end 新区间和旧区间有交集，直接合并旧区间和新区间，并删除旧区间
     * @author rays1
     *
     */
    static class Solution {
        
        public List<Interval> insert(List<Interval> intervals, Interval b) {

            intervals.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
            int index = 0;
            for (Iterator<Interval> ite = intervals.iterator(); ite.hasNext();) {
                Interval a = ite.next();
                if (b.end < a.start) {
                    intervals.add(index, b);
                    break;
                } else if (b.start <= a.end ) {
                    ite.remove();
                    index--;
                    b.start = Math.min(a.start, b.start);
                    b.end = Math.max(a.end, b.end);                    
                }
                index++;
            }
            intervals.remove(intervals.size() - 1);
            return intervals;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[][] arr = {
                { 1, 5},
                { 7, 8},
                {10, 13},
        };
        List<Interval> intervals = new ArrayList<>();
        for (int[] a : arr) {
            intervals.add(new Interval(a[0], a[1]));
        }
        Out.p(new Solution().insert(intervals, new Interval(2, 3)));

    }

}
